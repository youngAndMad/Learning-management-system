package danekerscode.courseservice.dto;

import danekerscode.courseservice.utils.AttachmentSource;

public record FileOperationDTO (
        Long target,
        AttachmentSource source,
        String name
){
}
