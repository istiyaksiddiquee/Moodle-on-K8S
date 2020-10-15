import { TypeOrmModuleOptions } from "@nestjs/typeorm";

export const mongoORMConfig: TypeOrmModuleOptions = {

    type: 'mongodb',
    url: 'mongodb://magnumopus:123456@localhost:27017/magnum_db',
    entities: [__dirname + '/../**/*.entity.ts'],
    synchronize: true,
    ssl: false,
    useUnifiedTopology: true,
    useNewUrlParser: true
};