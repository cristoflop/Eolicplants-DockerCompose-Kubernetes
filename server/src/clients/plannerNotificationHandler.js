import config from 'config';
import { updateEoloplant } from '../services/eoloplantService.js';

import DebugLib from 'debug';

const debug = new DebugLib('server:amqp:consumer');

const QUEUE = config.get('amqp.queues.progress');
const OPTIONS = config.get('amqp.options');

export default function configHandler(amqpChannel) {

  amqpChannel.assertQueue(QUEUE, OPTIONS);

  amqpChannel.consume(QUEUE, async msg => {
    
    const eoloplant = JSON.parse(msg.content.toString());

    debug('eoloplant received', eoloplant.id);

    await updateEoloplant(eoloplant);

  }, { noAck: true });
}