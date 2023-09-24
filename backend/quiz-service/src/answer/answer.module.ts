import {forwardRef, Module} from '@nestjs/common';
import { AnswerService } from './answer.service';
import { AnswerController } from './answer.controller';
import {Answer} from "./answer.entity";
import {TypeOrmModule} from "@nestjs/typeorm";
import {QuestionModule} from "../question/question.module";

@Module({
  imports: [TypeOrmModule.forFeature([Answer]), forwardRef(() => QuestionModule)],
  controllers: [AnswerController],
  providers: [AnswerService],
  exports: [AnswerService],
})
export class AnswerModule {}