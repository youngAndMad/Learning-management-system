package backend.userservice.repository;

import backend.userservice.model.SocialAccountLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialAccountLinkServiceRepository extends JpaRepository<SocialAccountLink,Long> {
}
