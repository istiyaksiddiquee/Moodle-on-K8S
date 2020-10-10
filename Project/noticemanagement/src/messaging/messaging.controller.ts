import { Controller, Get, Param, Logger } from '@nestjs/common';
import { MessagingService } from './messaging.service';

import * as config from 'config';

@Controller('messaging')
export class MessagingController {

    private logger = new Logger('MessagingController');

    constructor(private messagingService: MessagingService) {}

    @Get('/:name')
    getHelloMessage(@Param('name') name: string) {
                
        const testConfig = config.get('test');

        this.logger.log('got a call for get method');
        this.logger.log(`logger prop says: ${testConfig.get('info')}`);
        return this.messagingService.getHelloWorld(name);
    }
}
