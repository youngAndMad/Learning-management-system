package danekerscode.courseservice.service;

import danekerscode.courseservice.dto.FileOperationDTO;
import danekerscode.courseservice.utils.AttachmentSource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface MinIOService {

    void putObject(FileOperationDTO dto, MultipartFile file);

    void getObject(FileOperationDTO dto, HttpServletResponse response);

    void removeBucket(Long target, AttachmentSource source);

    void removeObject(FileOperationDTO dto);

}
