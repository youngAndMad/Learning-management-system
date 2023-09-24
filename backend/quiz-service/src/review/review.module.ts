import {forwardRef, Module} from '@nestjs/common';
import {ReviewService} from './review.service';
import {ReviewController} from './review.controller';
import {TypeOrmModule} from "@nestjs/typeorm";
import {Review} from "./review.entity";
import {QuestionModule} from "../question/question.module";
import {QuizModule} from "../quiz/quiz.module";
import {AnswerModule} from "../answer/answer.module";

@Module({
    imports: [
        TypeOrmModule.forFeature([Review]),
        forwardRef(() => QuestionModule),
        forwardRef(() => QuizModule),
        AnswerModule
    ],
    providers: [ReviewService],
    controllers: [ReviewController]
})
export class ReviewModule {
}
