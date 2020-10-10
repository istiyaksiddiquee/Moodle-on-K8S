import { IsNotEmpty, MaxLength, MinLength } from 'class-validator';

export class CreateNotificationDto {
  
  @IsNotEmpty()
  @MinLength(1)
  @MaxLength(100)
  description: string;
}