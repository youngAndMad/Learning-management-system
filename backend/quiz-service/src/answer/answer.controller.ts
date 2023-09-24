import {Body, Controller, Delete, Param, Patch} from '@nestjs/common';
import {AnswerService} from "./answer.service";
import {AnswerDTO} from "./answer.dto";

@Controller('answer')
export class AnswerController {

    constructor(
        private answerService: AnswerService
    ) {
    }

    @Delete(':id')
    async deleteAnswer(@Param('id') id: number) {
        return this.answerService.delete(id)
    }

    @Patch(':id')
    async update(@Param('id') id: number, @Body() answerDTO: AnswerDTO) {
        return this.answerService.update(id, answerDTO)
    }


}



