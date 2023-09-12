package danekerscode.courseservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    private Date time;

    @ManyToOne
    @JoinColumn
    private Course course;
    private Float point; // 0 - 10
    private String user; // user.full_name
    private Long userId;
}

