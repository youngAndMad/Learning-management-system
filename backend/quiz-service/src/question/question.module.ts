import { Module } from '@nestjs/common';
import { QuestionService } from './question.service';
import { QuestionController } from './question.controller';
import {Question} from "./question.entity";
import {TypeOrmModule} from "@nestjs/typeorm";

import { forwardRef } from '@nestjs/common';
import {AnswerService} from "../answer/answer.service";
import {QuizModule} from "../quiz/quiz.module";
import {AnswerModule} from "../answer/answer.module";

@Module({
  imports: [TypeOrmModule.forFeature([Question]), AnswerModule],
  controllers: [QuestionController],
  providers: [QuestionService],
  exports: [QuestionService],
})
export class QuestionModule {}


