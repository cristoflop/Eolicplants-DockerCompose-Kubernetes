import { Sequelize } from 'sequelize';
import mysql2 from 'mysql2';
import DebugLib from 'debug';

const debug = new DebugLib('server:mysql');

const DB_NAME = process.env.DB_NAME || 'eoloplantsDB' ;
const DB_USER = process.env.DB_USER || 'root' ;
const DB_PASS = process.env.DB_PASS || 'pass' ;
const HOST = process.env.DB_HOST || 'localhost' ;

export default new Sequelize(DB_NAME, DB_USER, DB_PASS, {
    dialect: 'mysql',
    host: HOST,
    dialectModule: mysql2,
    logging: false
});

process.on('exit', async () => {
    await sequelize.close();
    debug(`Closing mysql connection`);
});
