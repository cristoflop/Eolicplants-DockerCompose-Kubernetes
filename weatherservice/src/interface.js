const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');

const packageDefinition = protoLoader.loadSync(__dirname + '/../WeatherService.proto',
  {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true
  });

const wheatherServiceProto = grpc.loadPackageDefinition(packageDefinition);

module.exports = wheatherServiceProto.es.codeurjc.mastercloudapps.planner.grpc.WeatherService;