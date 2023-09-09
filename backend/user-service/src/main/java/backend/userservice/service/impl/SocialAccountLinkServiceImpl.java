package backend.userservice.service.impl;

import backend.userservice.dto.SocialAccountLinkDTO;
import backend.userservice.model.SocialAccountLink;
import backend.userservice.model.User;
import backend.userservice.repository.SocialAccountLinkServiceRepository;
import backend.userservice.service.SocialAccountLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialAccountLinkServiceImpl implements
        SocialAccountLinkService {

    private final SocialAccountLinkServiceRepository repository;

    @Override
    public SocialAccountLink save(SocialAccountLinkDTO dto, User user) {
        return repository.save(
                new SocialAccountLink(
                        dto.link(), dto.type() , user
                )
        );
    }

    @Override
    public void update(SocialAccountLink linkToUpdate) {
        repository.save(linkToUpdate);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
