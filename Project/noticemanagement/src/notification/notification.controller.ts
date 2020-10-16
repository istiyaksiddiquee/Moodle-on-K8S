import { Controller, Get, Logger, Post, Body, UsePipes, ValidationPipe } from '@nestjs/common';
import { CreateNotificationDto } from './dto/create-notification.dto';
import { NotificationService } from './notification.service';


@Controller('notification')
export class NotificationController {

    private logger = new Logger('NotificationController');
    constructor(private notificationService: NotificationService) { }

    // private redis = require("redis");

    // private client = this.redis.createClient({
    //     host: "127.0.0.1", 
    //     port: 6379
    // });

    // @Get()
    // pushData() {

    // const input_list = ["foo", "bar", "foo2", "bar2"];
    // this.client.rpush(input_list, function(err, res) {
    //     const inscribedlLogger = new Logger('RedisCallback');

    //     if (err) inscribedlLogger.error(err);
    //     else inscribedlLogger.log(res);            
    //   });        
    // }

    @Get()
    testENV() {
        this.logger.log(`this is DB_username: ${process.env.TEST as string}`);
    }

    @Get()
    getAllTasks() {                
        this.logger.log("Intercepted a call to get all notifications");
        return this.notificationService.getAllNotification();
    }

    @Post()
    @UsePipes(ValidationPipe)
    createNotification(
        @Body() createNotificationDTO: CreateNotificationDto,
    ) {
        this.logger.log('got a request for creating new notification');
        return this.notificationService.createNotification(createNotificationDTO);
    }
}
