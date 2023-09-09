package danekerscode.certificateservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "certificate_")
@Getter
@Setter
public class Certificate {

    private String id;
    private String name;
    private LocalDate time;
    private String owner;
}
