package danekerscode.courseservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn
    private Course course;

    private String plan;
    private String data;
    private String conclusion;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Attachment> attachments;

}
