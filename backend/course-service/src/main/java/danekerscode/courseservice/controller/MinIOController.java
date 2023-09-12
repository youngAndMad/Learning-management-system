package danekerscode.courseservice.controller;

import danekerscode.courseservice.dto.FileOperationDTO;
import danekerscode.courseservice.service.MinIOService;
import danekerscode.courseservice.utils.AttachmentSource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("storage")
public class MinIOController {

    private final MinIOService minIOService;

    @PostMapping("/upload")
    void uploadFileToMinIO(
            @RequestParam("file") MultipartFile file,
            @RequestParam Long target,
            @RequestParam AttachmentSource source,
            @RequestParam String name
    ) {
        minIOService.putObject(new FileOperationDTO(target,source,name),file);
    }

    @GetMapping("/download")
    void downloadFile(
            @RequestBody FileOperationDTO dto,
            HttpServletResponse response
    ) {
        minIOService.getObject(dto, response);
    }
}
