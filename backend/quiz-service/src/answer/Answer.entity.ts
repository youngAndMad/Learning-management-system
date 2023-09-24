import {PrimaryGeneratedColumn, Entity, Column, ManyToOne} from 'typeorm'
import {Question} from "../question/question.entity";
import {Exclude} from "class-transformer";


@Entity()
export class Answer {

    @PrimaryGeneratedColumn()
    public id: number;

    @Column()
    public value: string;

    @ManyToOne(() => Question, (question: Question) => question.answers)
    @Exclude({toPlainOnly:true})
    public question: Question;

    @Column({name: 'is_correct'})
    public isCorrect: boolean;

}