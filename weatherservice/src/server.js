const grpc = require('grpc');
const WeatherService = require('./interface');
const weatherServiceImpl = require('./weatherService');

const server = new grpc.Server();

server.addService(WeatherService.service, weatherServiceImpl);

const GRPC_HOST = process.env.GRPC_HOST || '127.0.0.1';
const GRPC_PORT = process.env.GRPC_PORT || 9090;

server.bind(`${GRPC_HOST}:${GRPC_PORT}`, grpc.ServerCredentials.createInsecure());

console.log(`gRPC server running at ${GRPC_HOST}:${GRPC_PORT}`);

server.start();