import {Body, ClassSerializerInterceptor, Controller, Delete, Param, Post, UseInterceptors} from '@nestjs/common';
import {QuizService} from "./quiz.service";
import {QuizDTO} from "./quiz.dto";

@Controller('quiz')
export class QuizController {

    constructor(
        private quizService: QuizService
    ) {
    }

    @Post()
    @UseInterceptors(ClassSerializerInterceptor)
    async create(
        @Body() quizDTO: QuizDTO
    ) {
        return this.quizService.save(quizDTO)
    }

    @Delete(':id')
    async delete(@Param('id') id: number) {
        return this.quizService.delete(id)
    }




}
