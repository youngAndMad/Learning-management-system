package danekerscode.certificateservice;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import danekerscode.certificateservice.dto.CertificateDTO;
import danekerscode.certificateservice.service.CertificateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileOutputStream;

@SpringBootApplication
public class CertificateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertificateServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(CertificateService service){
        return args -> {
            System.out.println(service.generate(new CertificateDTO(
                    "Calculus",
                    "Daneker",
                    "todo"
            )));
        };
    }

}
