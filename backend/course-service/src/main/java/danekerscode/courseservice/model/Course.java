package danekerscode.courseservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Course  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String header;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "course"
    )
    private List<Lesson> lessons;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "course"
    )
    private List<Outline> outline;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Attachment> attachments;

}
