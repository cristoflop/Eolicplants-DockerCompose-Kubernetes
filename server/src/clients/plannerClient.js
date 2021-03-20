import { amqpChannel } from '../connections/amqpConnection.js';
import config from 'config';
import DebugLib from 'debug';

const debug = new DebugLib('server:amqp:producer');

const QUEUE = config.get('amqp.queues.creation');
const OPTIONS = config.get('amqp.options');

export function sendRequestToPlanner(request) {

  amqpChannel.assertQueue(QUEUE, OPTIONS);

  if (typeof request !== "string") {
    request = JSON.stringify(request);
  } 

  debug(`sending ${request}`);

  amqpChannel.sendToQueue(QUEUE, Buffer.from(request));
}