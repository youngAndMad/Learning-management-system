import {ManyToOne, PrimaryGeneratedColumn, Entity, Column, OneToMany} from 'typeorm'
import {Quiz} from "../quiz/quiz.entity";
import {Answer} from "../answer/answer.entity";
import {Exclude} from "class-transformer";


@Entity()
export class Question {

    @PrimaryGeneratedColumn()
    public id: number;

    @ManyToOne(() => Quiz, (quiz: Quiz) => quiz.questions)
    @Exclude({toPlainOnly:true})
    public quiz: Quiz;

    @Column()
    public value: string;

    @OneToMany(() => Answer, (answer: Answer) => answer.question)
    public answers: Answer[];

}