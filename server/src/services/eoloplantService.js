import { sentToUser, sentToAllUsers } from '../connections/wsConnection.js';
import { EoloPlant } from '../models/EoloPlant.js';
import { sendRequestToPlanner } from "../clients/plannerClient.js";

import DebugLib from 'debug';

const debug = new DebugLib('server:eoloplantService');

const usersByPlantId = new Map();

export async function getAllPlants() {
    return EoloPlant.findAll();
}

export async function getEoloplantById(id) {
    return await EoloPlant.findOne({ where: { id } });
}

export async function removeEoloplantById(id) {
    const plant = await getEoloplantById(id);
    if (plant !== null) {
        plant.destroy();
    }
    return plant;
}

export async function createEoloplant(eoloplantCreationRequest, userId) {

    debug('createEoloplant', eoloplantCreationRequest, userId);

    const eoloplant = EoloPlant.build(eoloplantCreationRequest);
    await eoloplant.save();

    usersByPlantId.set(eoloplant.id, userId);

    sendRequestToPlanner({ id: eoloplant.id, city: eoloplant.city });

    return eoloplant;
}

export async function updateEoloplant(eoloplant) {

    debug('updateEoloplant', eoloplant);

    await EoloPlant.update(eoloplant, { where: { id: eoloplant.id } });

    const updatedEoloplant = await getEoloplantById(eoloplant.id);

    notifyUsers(updatedEoloplant);
}

export function notifyUsers(eoloplant) {

    if (eoloplant.completed) {
        sentToAllUsers(eoloplant);
    } else {
        sentToUser(usersByPlantId.get(eoloplant.id), eoloplant);
    }
}

