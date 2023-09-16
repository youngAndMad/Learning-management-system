import {Controller, Get, Param, Query, Res} from '@nestjs/common';
import {Response} from 'express';
import {QrService} from "../service/qr.service";

@Controller('api/v1/qr-service/qr-code')
export class QrCodeController {
    constructor(private qrService: QrService) {
    }

    @Get()
    generateQrCode(
        @Query('data') data: string,
        @Res() res: Response
    ) {
        this.qrService.generateQrCode(data, res)
    }

}
