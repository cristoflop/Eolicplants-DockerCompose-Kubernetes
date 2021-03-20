import { Sequelize } from 'sequelize';
import mysql2 from 'mysql2';
import DebugLib from 'debug';

const debug = new DebugLib('server:mysql');

const DB_NAME = process.env.DB_NAME || 'eoloplants' ;
const DB_USER = process.env.DB_USER || 'root' ;
const DB_PORT = process.env.DB_PORT || '3306' ;
const DB_PASS = process.env.DB_PASS || 'root' ;
const DB_HOST = process.env.DB_HOST || 'localhost' ;

export default new Sequelize(DB_NAME, DB_USER, DB_PASS, {
    dialect: 'mysql',
    host: DB_HOST,
    port: DB_PORT,
    dialectModule: mysql2,
    logging: false
});

process.on('exit', async () => {
    await sequelize.close();
    debug(`Closing mysql connection`);
});
