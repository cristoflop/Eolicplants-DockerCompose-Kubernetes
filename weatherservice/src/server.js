const grpc = require('grpc');
const WeatherService = require('./interface');
const weatherServiceImpl = require('./weatherService');

const server = new grpc.Server();

server.addService(WeatherService.service, weatherServiceImpl);

const GRPC_PORT = process.env.GRPC_PORT || 9090;

server.bind(`0.0.0.0:${GRPC_PORT}`, grpc.ServerCredentials.createInsecure());

console.log(`gRPC server running at 0.0.0.0:${GRPC_PORT}`);

server.start();