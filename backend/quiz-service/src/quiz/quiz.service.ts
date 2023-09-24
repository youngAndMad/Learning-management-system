import {Injectable, NotFoundException} from '@nestjs/common';
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

    async find(id: number) {
        let quiz = this.quizRepository.findOneBy({id})

        if (!quiz) {
            throw new NotFoundException(`quiz by id ${id} not found`);
        }

        return quiz;
    }

    async search(name: string) {
        return this.quizRepository.findBy({name: name})
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
            .save(plainToClass(Quiz, quizDTO))

        let questionPromises = quizDTO.questions
            .map(async (question) => await this.questionService.save(question, quiz))

        quiz.questions = await Promise.all(questionPromises)

        return await this.quizRepository.save(quiz)
    }

    private updateModel(
        quiz: Quiz,
        quizDTO: QuizDTO
    ) {
        quiz.reviewPermitted = quizDTO.reviewPermitted ?? quiz.reviewPermitted;
        quiz.name = quizDTO.name ?? quiz.name;
        quiz.start = quizDTO.start ?? quiz.start;
        quiz.end = quizDTO.end ?? quiz.end;
        quiz.duration = quizDTO.duration ?? quiz.duration;
        return quiz;
    }


    async update(
        id: number,
        quizDTO: QuizDTO
    ) {
        let quiz = await this.find(id)

        let updated = this.updateModel(quiz,quizDTO)

        return this.quizRepository.save(updated)
    }


}
