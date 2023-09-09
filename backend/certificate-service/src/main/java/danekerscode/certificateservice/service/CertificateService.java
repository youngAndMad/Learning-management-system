package danekerscode.certificateservice.service;

import danekerscode.certificateservice.dto.CertificateDTO;
import danekerscode.certificateservice.model.Certificate;

public interface CertificateService {
    Certificate generate(CertificateDTO dto);
}
