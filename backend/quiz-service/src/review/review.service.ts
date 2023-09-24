import {Injectable, NotFoundException} from '@nestjs/common';
import {InjectRepository} from "@nestjs/typeorm";
import {Review} from "./review.entity";
import {Repository} from "typeorm";
import {QuizService} from "../quiz/quiz.service";
import {QuestionService} from "../question/question.service";

@Injectable()
export class ReviewService {

    constructor(
        @InjectRepository(Review) private reviewRepository: Repository<Review>,
        private quizService: QuizService,
        private questionService: QuestionService
    ) {
    }

    async find(
        id: number
    ) {
        let review = await this.reviewRepository.findOneBy({id})

        if (!review) {
            throw new NotFoundException(`review by id: ${id} not found`)
        }

        return review
    }


}
