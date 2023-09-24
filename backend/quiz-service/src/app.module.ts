import {Module} from '@nestjs/common';
import {AppController} from './app.controller';
import {AppService} from './app.service';
import {TypeOrmModule} from '@nestjs/typeorm';
import { QuizModule } from './quiz/quiz.module';
import { AnswerModule } from './answer/answer.module';
import { QuestionModule } from './question/question.module';


@Module({
        imports: [TypeOrmModule.forRoot({
            type: 'postgres',
            host: 'localhost',
            port: 5432,
            username: 'postgres',
            password: 'postgres',
            database: 'lms_quiz',
            synchronize: true,
            autoLoadEntities: true,
        }), QuizModule, AnswerModule, QuestionModule],
        controllers: [AppController],
        providers: [AppService],
    }
)
export class AppModule {
}
