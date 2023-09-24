import {Controller, Delete, Param} from '@nestjs/common';
import {QuestionService} from "./question.service";

@Controller('question')
export class QuestionController {
    constructor(private questionService: QuestionService) {
    }

    @Delete(':id')
    async delete(@Param('id') id: number) {
        return this.questionService.delete(id)
    }


}
