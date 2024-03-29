package danekerscode.certificateservice.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import danekerscode.certificateservice.dto.CertificateDTO;
import danekerscode.certificateservice.model.Certificate;
import danekerscode.certificateservice.repository.CertificateRepository;
import danekerscode.certificateservice.service.CertificateService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateRepository certificateRepository;

    @Override
    public Certificate generate(CertificateDTO dto) {
        generatePDF(dto); // todo send to email

        var certificate = new Certificate(dto.name(),dto.owner());

        return certificateRepository.save(certificate);
    }

    @SneakyThrows
    private static void generatePDF(CertificateDTO dto) {
        var document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("new_test.pdf"));

        document.open();

        var paragraph = new Paragraph();

        var title = new Chunk("Certificate of Achievement", FontFactory.getFont(FontFactory.COURIER, 36));
        paragraph.add(title);

        var name = new Chunk(dto.name(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 24));
        var owner = new Chunk(dto.owner(), FontFactory.getFont(FontFactory.TIMES_ROMAN, 24));
        var completeCourse = new Chunk("Successfully completed the course", FontFactory.getFont(FontFactory.TIMES_ROMAN, 24));

        paragraph.add(name);
        paragraph.add(owner);
        paragraph.add(completeCourse);

        paragraph.setAlignment(Element.ALIGN_CENTER);


        document.add(paragraph);
        document.close();
    }

}
