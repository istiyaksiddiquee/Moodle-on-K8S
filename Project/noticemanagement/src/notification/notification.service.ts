import { Injectable } from '@nestjs/common';
import { NotificationRepository } from './notificatio.repository';
import { Logger } from '@nestjs/common';
import { CreateNotificationDto } from './dto/create-notification.dto';

@Injectable()
export class NotificationService {

    private logger = new Logger('NotificationService');

    constructor(private notificationRepository: NotificationRepository) { }

    async getAllNotification() {
        const [notifications, notificationCount] = await this.notificationRepository.findAndCount();
        this.logger.log(`${notificationCount} notifications found.`);
        return notifications;
    }

    async createNotification(createNotificationDTO: CreateNotificationDto) {
        return await this.notificationRepository.createNotification(createNotificationDTO);
    }

}
