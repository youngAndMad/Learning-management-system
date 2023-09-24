import {
    Body,
    ClassSerializerInterceptor,
    Controller,
    Delete,
    Get,
    Param, Patch,
    Post,
    Query,
    UseInterceptors
} from '@nestjs/common';
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
    async delete(
        @Param('id') id: number
    ) {
        return this.quizService.delete(id)
    }

    @Get(':id')
    async find(
        @Param('id') id: number
    ) {
        return this.quizService.find(id)
    }

    @Get()
    async findByName(
        @Query('name') name: string
    ) {
        return this.quizService.search(name)
    }

    @Patch(':id')
    async update(
        @Param('id') id: number,
        @Body() quizDTO: QuizDTO
    ) {
        return this.quizService.update(id, quizDTO)
    }


}
