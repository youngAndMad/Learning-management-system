package danekerscode.certificateservice.controller;

import danekerscode.certificateservice.dto.CertificateDTO;
import danekerscode.certificateservice.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping
    ResponseEntity<?> save(
            @RequestBody CertificateDTO dto
    ) {
        return ResponseEntity
                .ok(certificateService.generate(dto));
    }
}
