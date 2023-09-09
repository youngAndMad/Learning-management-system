package backend.userservice.model;

import backend.userservice.utils.SocialAccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

    public SocialAccountLink(String link, SocialAccountType type,User user) {
        this.link = link;
        this.type = type;
        this.user = user;
    }
}
