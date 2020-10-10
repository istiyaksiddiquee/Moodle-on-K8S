import { Injectable } from '@nestjs/common';

@Injectable()
export class MessagingService {

    getHelloWorld(name: string) {
        return "hello" + name;
    }

}
