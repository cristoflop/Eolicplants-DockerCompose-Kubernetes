import bodyParser from "body-parser";
import express from "express";
import { routes } from "../routes/eoloplantsRouter.js";

export function createExpressServer() {

  const server = express();
  server.use(bodyParser.urlencoded({extended: true}));
  server.use(express.json());
  server.use('/', routes);

  server.use(express.static('public'));

  return server;
}