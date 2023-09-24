import {ManyToOne, PrimaryGeneratedColumn, Entity, Column, OneToMany} from 'typeorm'
import {Quiz} from "../quiz/Quiz.entity";
import {Answer} from "../answer/Answer.entity";


@Entity()
export class Question {

    @PrimaryGeneratedColumn()
    public id: number;

    @ManyToOne(() => Quiz, (quiz: Quiz) => quiz.questions)
    public quiz: Quiz;

    @Column()
    public value: string;

    @OneToMany(() => Answer, (answer: Answer) => answer.question)
    public answers: Answer[];

}