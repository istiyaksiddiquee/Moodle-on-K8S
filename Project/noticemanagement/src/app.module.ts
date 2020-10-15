import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

import { NotificationModule } from './notification/notification.module';
import { MessagingModule } from './messaging/messaging.module';
import { pgORMConfig } from './config/pgorm.config';
import { mongoORMConfig } from './config/mongoorm.config';

@Module({
  imports: [
    TypeOrmModule.forRoot(pgORMConfig),
    NotificationModule, 
    MessagingModule
  ],
})
export class AppModule {}