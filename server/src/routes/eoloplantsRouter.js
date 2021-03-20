import { Router } from 'express';
import { removeEoloplantById, getEoloplantById, getAllPlants, createEoloplant } from "../services/eoloplantService.js";

import DebugLib from 'debug';

const debug = new DebugLib('server:rest');

export const routes = Router();

routes.get('/api/eoloplants', async function (req, res, next) {
  const plants = await getAllPlants();
  if (plants.length === 0)
    return res.status(404).send('Not Found!');
  return res.json(plants);
});

routes.post('/api/eoloplants', async (req, res) => {

  const userId = req.headers['user-key'];

  debug('Eoloplant creation request received for user', userId)

  try {
    const eoloplant = await createEoloplant(req.body, userId);
    return res.status(202).json(eoloplant);
  } catch (e) {
    return res.status(409).send('Bad request! '+e.message);
  }

});

routes.get("/api/eoloplants/:id", async (req, res) => {
  const plant = await getEoloplantById(req.params.id);
  if (plant === null)
    return res.status(404).send('Not Found!');
  return res.json(plant);
});

routes.delete("/api/eoloplants/:id", async (req, res) => {
  const plant = removeEoloplantById(req.params.id);
  if (plant === null)
    return res.status(404).send('Not Found!');
  return res.json(plant);
});
