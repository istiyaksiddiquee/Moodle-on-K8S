import { ObjectID } from "mongodb";
import { BaseEntity, Column, Entity, PrimaryColumn } from "typeorm";

@Entity()
export class Notification extends BaseEntity {

    @PrimaryColumn()
    notification_id: string; 

    @Column()
    notification_details: string;
}