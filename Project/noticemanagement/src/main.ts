import { Logger } from '@nestjs/common';
import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';

import * as config from 'config';

async function bootstrap() {
  
  const logger = new Logger('bootstrap');
  
  const serverConfig = config.get('server');
  let SERVER_PORT = serverConfig.get('port'); 
  
  if (process.env.SERVER_PORT != null) {
    SERVER_PORT = process.env.SERVER_PORT; 
  }
    
  const app = await NestFactory.create(AppModule);
  
  await app.listen(SERVER_PORT);

  logger.log(`Server is listening to port: ${SERVER_PORT}`);

}

bootstrap();
