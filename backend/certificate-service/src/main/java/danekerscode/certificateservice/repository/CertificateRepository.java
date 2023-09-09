package danekerscode.certificateservice.repository;

import danekerscode.certificateservice.model.Certificate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends MongoRepository<Certificate,String> {
}
