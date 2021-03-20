import { connectAmqp } from "./connections/amqpConnection.js";
import { createWsServer } from './connections/wsConnection.js';
import { createExpressServer } from './connections/restConnection.js';

const server = createExpressServer();
createWsServer(server, '/eoloplants')
await connectAmqp();

server.listen(3000, () => console.log('Server listening on port 3000!'));
