import {Injectable} from '@nestjs/common';
import {InjectRepository} from "@nestjs/typeorm";
import {Repository} from "typeorm";
import {Quiz} from "./quiz.entity";
import {QuizDTO} from "./quiz.dto";
import {QuestionService} from "../question/question.service";
import {plainToClass} from "class-transformer";

@Injectable()
export class QuizService {

    constructor(
        @InjectRepository(Quiz) private quizRepository: Repository<Quiz>,
        private questionService: QuestionService
    ) {
    }

    async delete(
        id: number
    ) {
        await this.quizRepository.delete(id)
    }

    async save(
        quizDTO: QuizDTO
    ) {
        let quiz = await this.quizRepository
            .save(plainToClass(Quiz,quizDTO))

        console.log(quiz)

        let questionPromises = quizDTO.questions
            .map(async (question) => await this.questionService.save(question,quiz))

        quiz.questions = await  Promise.all(questionPromises)

        return await this.quizRepository.save(quiz)
    }


}
