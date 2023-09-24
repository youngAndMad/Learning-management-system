import {Injectable} from '@nestjs/common';
import {InjectRepository} from "@nestjs/typeorm";
import {Answer} from "./answer.entity";
import {Repository} from "typeorm";
import {plainToClass} from 'class-transformer';
import {AnswerDTO} from "./answer.dto";

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
        answerDTO: AnswerDTO
    ) {
        let answer = plainToClass(Answer, answerDTO)

        return await this.answerRepository.save(answer)
    }


}
