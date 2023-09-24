import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from 'typeorm';
import {Question} from "../question/Question.entity";

@Entity()
export class Quiz {

    @PrimaryGeneratedColumn()
    public id: number;

    @Column()
    public name: string;

    @OneToMany(() => Question, (question: Question) => question.quiz)
    public questions: Question [];

    @Column()
    public reviewPermitted: boolean;

    @Column('timestamptz')
    public start: Date;

    @Column('timestamptz')
    public end: Date;

    @Column()
    public duration: number;

}