import { Notification } from './notification.entity';
import { EntityRepository, Repository } from 'typeorm';
import { CreateNotificationDto } from './dto/create-notification.dto';

import { Logger, InternalServerErrorException, Injectable } from '@nestjs/common';

import { v4 as uuidv4 } from 'uuid';

@EntityRepository(Notification)
@Injectable()
export class NotificationRepository extends Repository<Notification> {

    private logger = new Logger('NotificationRepository');

    async createNotification(
        createNotificationDto: CreateNotificationDto,
    ): Promise<Notification> {

        const { description } = createNotificationDto;

        const notification = new Notification();
        notification.notification_id = uuidv4(),
        notification.notification_details = description;

        try {
            await notification.save();
        } catch (error) {
            this.logger.error(
                `Failed to create notification. Data: ${createNotificationDto}`,
                error.stack,
            );
            throw new InternalServerErrorException();
        }

        delete notification.notification_id;
        return notification;
    }
}
