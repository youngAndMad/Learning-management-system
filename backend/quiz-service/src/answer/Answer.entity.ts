import {PrimaryGeneratedColumn, Entity, Column, ManyToOne} from 'typeorm'
import {Question} from "../question/Question.entity";


@Entity()
export class Answer {

    @PrimaryGeneratedColumn()
    public id: number;

    @Column()
    public value: string;

    @ManyToOne(() => Question, (question: Question) => question.answers)
    public question: Question;

    @Column({name: 'is_correct'})
    public isCorrect: boolean;

}