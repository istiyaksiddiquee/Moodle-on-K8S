import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

import { NotificationService } from './notification.service';
import { NotificationController } from './notification.controller';
import { NotificationRepository } from './notificatio.repository';

@Module({
  imports: [
    TypeOrmModule.forFeature([NotificationRepository])
  ],
  controllers: [NotificationController],
  providers: [NotificationService]
})
export class NotificationModule {}
