import {Injectable, NotFoundException} from '@nestjs/common';
import {Question} from "./question.entity";
import {InjectRepository} from "@nestjs/typeorm";
import {Repository} from "typeorm";
import {QuestionDTO} from "./question.dto";
import {AnswerService} from "../answer/answer.service";
import {plainToClass} from "class-transformer";
import {Quiz} from "../quiz/quiz.entity";

@Injectable()
export class QuestionService {

    constructor(
        @InjectRepository(Question) private questionRepository: Repository<Question>,
        private answerService: AnswerService
    ) {
    }

    async delete(
        id: number
    ) {
        await this.questionRepository.delete(id)
    }

    async save(
        questionDTO: QuestionDTO,
        quiz: Quiz
    ) {

        let question = await this.questionRepository
            .save(plainToClass(Question, questionDTO))

        let answersPromises = questionDTO.answers.map(
            async (answer) => await this.answerService.create(answer, question)
        );

        question.answers = await Promise.all(answersPromises)
        question.quiz = quiz

        return await this.questionRepository.save(question)
    }

    private async findById(
        id: number
    ) {
        return await this.questionRepository.findOneBy({id})
    }

    async update(
        id: number,
        value: string
    ) {
        let question = await this.findById(id)

        if (!question) {
            throw new NotFoundException(`question by id ${id} not found`)
        }

        question.value = value

        return this.questionRepository.save(question)
    }


    async check(
        id: number,
        answers: number[],
        withReview: boolean
    ) {
        let question = await this.findById(id)

        let validAnswers = question.answers.filter(
            a => answers.some(answer => answer === a.id)
        )

        let percentage = (validAnswers.length / question.answers.length) * 100

        if (!withReview) {
            return percentage
        }

        return {
            question: question,
            percentage: percentage,
            validAnswers: validAnswers
        }
    }


}
