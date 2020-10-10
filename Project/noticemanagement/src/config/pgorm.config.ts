import { TypeOrmModuleOptions } from '@nestjs/typeorm';
import * as config from 'config';

const dbConfig = config.get('db');

export const pgORMConfig: TypeOrmModuleOptions = {
  type: 'postgres',
  host: dbConfig.get('host'),
  port: dbConfig.get('port'),
  username: dbConfig.get('username'),
  password: dbConfig.get('password'),
  database: dbConfig.get('database'),
  entities: [__dirname + '/../**/*.entity.{js,ts}'],
  synchronize: dbConfig.get('synchronize'),
};