import {IsBoolean, IsNotEmpty, IsString} from "class-validator";

export class AnswerDTO {
    @IsBoolean()
    @IsNotEmpty()
    readonly isCorrect: boolean;
    @IsNotEmpty()
    @IsString()
    readonly value: string;
}