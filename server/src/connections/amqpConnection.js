import { connect } from 'amqplib';
import DebugLib from 'debug';
import configHandler from '../clients/plannerNotificationHandler.js';

const debug = new DebugLib('server:amqp');

export let amqpChannel;

const AMQP_USER = process.env.AMQP_USER || 'guest' ;
const AMQP_PASS = process.env.AMQP_PASS || 'guest' ;
const AMQP_HOST = process.env.AMQP_HOST || 'localhost' ;
const AMQP_PORT = process.env.AMQP_PORT || '5672' ;

export async function connectAmqp() {

  const conn = await connect(`amqp://${AMQP_USER}:${AMQP_PASS}@${AMQP_HOST}:${AMQP_PORT}`);
  amqpChannel = await conn.createChannel();
  
  configHandler(amqpChannel);

  process.on('exit', () => {
    amqpChannel.close();
    debug(`Closing rabbitmq channel`);
  });
}
