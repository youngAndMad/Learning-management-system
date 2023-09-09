package backend.userservice.model;

import backend.userservice.utils.SocialAccountType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class SocialAccountLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String link;

    @Enumerated(EnumType.STRING)
    private SocialAccountType type;

    @ManyToOne
    @JoinColumn
    private User user;

    public SocialAccountLink(String link, SocialAccountType type) {
        this.link = link;
        this.type = type;
    }
}
