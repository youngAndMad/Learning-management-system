import {Injectable} from '@nestjs/common';
import {Response} from "express";
import * as qr from "qr-image";

@Injectable()
export class QrService {
    generateQrCode(
        data: string,
        res: Response
    ) {
        try {
            const qrCode = qr.image(data, {
                    type: 'png',
                    size: 50
                }
            );

            res.setHeader('Content-Type', 'image/png');
            qrCode.pipe(res);
        } catch (error) {
            res.status(500).json({error: `Failed to generate QR code, error ${error}`});
        }
    }
}
