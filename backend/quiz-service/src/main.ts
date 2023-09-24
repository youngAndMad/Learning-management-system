import {NestFactory} from '@nestjs/core';
import {AppModule} from './app.module';
import {ValidationPipe} from "@nestjs/common";
import {DocumentBuilder, SwaggerModule} from '@nestjs/swagger';
import {GlobalExceptionFilter} from "./global-exception.filter";

const port = 4000;

async function bootstrap() {
    const app = await NestFactory.create(AppModule);

    app.useGlobalPipes(new ValidationPipe());

    const serverBasePath = 'api/v1/quiz-service';

    const config = new DocumentBuilder()
        .setTitle('LMS Quiz Service')
        .setDescription('API for passing quizzes')
        .setVersion('1.0')
        .addOAuth2(
            {
                name: 'Keycloak',
                type: 'oauth2',
                bearerFormat: 'Bearer'
            }
        )
        .setBasePath(serverBasePath)
        .build();

    const document = SwaggerModule.createDocument(app, config);
    SwaggerModule.setup('api', app, document);


    app.useGlobalFilters(new GlobalExceptionFilter());
    app.setGlobalPrefix(serverBasePath)

    await app.listen(port);
}

bootstrap().then(() => {
    console.log(`App running on port ${port}`)
});
