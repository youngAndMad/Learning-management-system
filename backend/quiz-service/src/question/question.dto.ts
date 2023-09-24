import {IsNotEmpty, IsString} from "class-validator";
import {AnswerDTO} from "../answer/answer.dto";

export class QuestionDTO{

    @IsNotEmpty()
    @IsString()
    readonly value: string;

    @IsNotEmpty()
    readonly answers : AnswerDTO[];

}