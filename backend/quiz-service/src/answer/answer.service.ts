import {Injectable, NotFoundException} from '@nestjs/common';
import {InjectRepository} from "@nestjs/typeorm";
import {Answer} from "./answer.entity";
import {Repository} from "typeorm";
import {plainToClass} from 'class-transformer';
import {AnswerDTO} from "./answer.dto";
import {Question} from "../question/question.entity";

@Injectable()
export class AnswerService {

    constructor(
        @InjectRepository(Answer) private answerRepository: Repository<Answer>
    ) {
    }

    async delete(
        id: number
    ) {
        await this.answerRepository.delete(id)
    }

    async create(
        answerDTO: AnswerDTO,
        question: Question
    ) {
        let answer = plainToClass(Answer, answerDTO)

        answer.question = question

        return await this.answerRepository.save(answer)
    }

    async update(
        id: number, answerDTO: AnswerDTO
    ) {
        let answer = await this.answerRepository.findOne({where: {'id': id}})

        if (!answer) {
            throw new NotFoundException(`answer by id: ${id} not found`);
        }

        answer.isCorrect = answerDTO.isCorrect
        answer.value = answerDTO.value

        await this.answerRepository.update(id, {
            isCorrect: answerDTO.isCorrect,
            value: answerDTO.value
        })
    }
}
