import {NestFactory} from '@nestjs/core';
import {AppModule} from './app.module';

const port: number = 8085

async function bootstrap() {
    const app = await NestFactory.create(AppModule);
    await app.listen(port);
}

bootstrap().then(r => console.log(`app running port ${port}`));
