import { TypeOrmModuleOptions } from "@nestjs/typeorm";

export const mongoORMConfig: TypeOrmModuleOptions = {

    type: 'mongodb',
    url: 'mongodb://localhost:27017/notificationmgmt',     
    entities: [__dirname + '/../**/*.entity.ts'],
    synchronize: true
};