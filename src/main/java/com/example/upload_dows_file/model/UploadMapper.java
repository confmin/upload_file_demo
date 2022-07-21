package com.example.upload_dows_file.model;

public class UploadMapper {
    public static UploadDto map(UploadEntity uploadEntity)
    {
        UploadDto uploadDto = new UploadDto();
        uploadDto.setId(uploadEntity.getId());
        uploadDto.setFileName(uploadEntity.getFilename());
        uploadDto.setFile_url(uploadEntity.getFileUrl());
        return uploadDto ;
    }
}
