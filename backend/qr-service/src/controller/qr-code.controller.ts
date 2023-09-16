import {Controller, Get, Param, Query, Res} from '@nestjs/common';
import * as qr from 'qr-image';
import {Response} from 'express';
import {QrService} from "../service/qr.service";

@Controller('qr-code')
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
