const grpc = require('grpc');
const WeatherService = require('./interface');
const weatherServiceImpl = require('./weatherService');

const server = new grpc.Server();

server.addService(WeatherService.service, weatherServiceImpl);

const port = process.env.PORT || 9090;

server.bind(`127.0.0.1:${port}`, grpc.ServerCredentials.createInsecure());

console.log('gRPC server running at http://127.0.0.1:9090');

server.start();