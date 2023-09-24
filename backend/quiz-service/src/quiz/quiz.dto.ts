import {IsBoolean, IsDate, IsNotEmpty, IsNumber, IsString} from "class-validator";
import {QuestionDTO} from "../question/question.dto";

export class QuizDTO {
    @IsNotEmpty()
    @IsString()
    readonly name: string;

    @IsNotEmpty()
    readonly questions: QuestionDTO[];

    @IsBoolean()
    readonly reviewPermitted: boolean;

    readonly start: Date;

    readonly end: Date;

    @IsNumber()
    readonly duration: number;
}
