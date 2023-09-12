package danekerscode.courseservice.service.impl;

import danekerscode.courseservice.dto.FileOperationDTO;
import danekerscode.courseservice.service.MinIOService;
import danekerscode.courseservice.utils.AttachmentSource;
import io.minio.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@Service
@RequiredArgsConstructor
public class MinIOServiceImpl implements MinIOService {

    private final MinioClient minioClient;


    @Override
    public void putObject(FileOperationDTO dto, MultipartFile file) {
        var bucketName = toBucketName(dto.source(),dto.target());
        checkBucketExisting(bucketName);
        try {
            var in = new ByteArrayInputStream(file.getBytes());
            var objectName = file.getOriginalFilename();
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName)
                    .stream(in, -1, 10485760).build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SneakyThrows
    public void getObject(FileOperationDTO dto, HttpServletResponse response) {

        var minioInputStream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(toBucketName(dto.source(),dto.target()))
                        .object(dto.name())
                        .build()
        );

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + dto.name() + "\"");

        try (
                var inputStream = minioInputStream;
                var outputStream = response.getOutputStream()
        ) {
            var buffer = new byte[10240];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

    }

    @Override
    public void removeBucket(Long target, AttachmentSource source) {
        var bucketName = toBucketName(source,target);

        try {
            minioClient.removeBucket(
                    RemoveBucketArgs.builder()
                            .bucket(bucketName)
                            .build()
            );
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void removeObject(FileOperationDTO dto) {
        var bucketName = toBucketName(dto.source(),dto.target());
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(dto.name())
                            .build()
            );
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @SneakyThrows
    private void checkBucketExisting(String bucketName) {
        if (minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(bucketName)
                        .build()
        )) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(bucketName)
                            .build()
            );
        }
    }

    private String toBucketName(AttachmentSource source,Long target) {
        return source.name().concat("_") + target;
    }
}
