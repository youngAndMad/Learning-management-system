import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { QrCodeController } from './controller/qr-code.controller';
import { QrService } from './service/qr.service';

@Module({
  imports: [],
  controllers: [AppController, QrCodeController],
  providers: [AppService, QrService],
})
export class AppModule {}
