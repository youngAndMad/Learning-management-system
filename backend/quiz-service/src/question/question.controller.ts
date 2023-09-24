import {Controller, Delete, Param, Patch, Query} from '@nestjs/common';
import {QuestionService} from "./question.service";

@Controller('question')
export class QuestionController {
    constructor(private questionService: QuestionService) {
    }

    @Delete(':id')
    async delete(@Param('id') id: number) {
        return this.questionService.delete(id)
    }

    @Patch(':id')
    async update(@Param('id') id:number, @Query('value') value:string){
        return this.questionService.update(id,value)
    }


}
