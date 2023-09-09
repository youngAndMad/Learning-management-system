package danekerscode.certificateservice.dto;

public record CertificateDTO(
        String name,
        String owner,
        String ownerEmail
) {
}
