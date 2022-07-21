package com.example.upload_dows_file.services;

import com.example.upload_dows_file.utils.respon.DataRespon;
import com.example.upload_dows_file.utils.respon.UploadRespon;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadService {
    UploadRespon saveFile(MultipartFile file);
    Resource loadFileAsResource(String fileName);
    DataRespon getAll();
    ResponseEntity delete(Integer id);
    ResponseEntity update(Integer id , MultipartFile file);
}
