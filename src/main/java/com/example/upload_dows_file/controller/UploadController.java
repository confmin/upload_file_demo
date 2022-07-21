package com.example.upload_dows_file.controller;

import com.example.upload_dows_file.services.UploadService;
import com.example.upload_dows_file.utils.respon.DataRespon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class UploadController {
    @Autowired
    private UploadService  uploadService ;
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
    {
        return new ResponseEntity<>(uploadService.saveFile(file), HttpStatus.ACCEPTED);
    }
    @PostMapping("/multiupload")
    public List<ResponseEntity<?>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> upload(file))
                .collect(Collectors.toList());
    }
    @GetMapping("/view/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = uploadService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll()
    {

        return new ResponseEntity<DataRespon>(uploadService.getAll(),HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<?> delete(@PathVariable Integer id)
    {
        return new ResponseEntity<>(uploadService.delete(id),HttpStatus.OK) ;
    }
    @PutMapping("update/{id}")
    public  ResponseEntity<?> update(@PathVariable Integer id ,@RequestParam("file") MultipartFile file){

        return new ResponseEntity<>(uploadService.update(id,file),HttpStatus.ACCEPTED);
    }
}
