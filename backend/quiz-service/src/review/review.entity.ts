import {Entity, PrimaryGeneratedColumn} from "typeorm";

@Entity()
export class Review{

    @PrimaryGeneratedColumn()
    id:number;

}
