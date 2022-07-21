package com.example.upload_dows_file.utils.respon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadRespon {
 private String filename ;
private  String url ;
private String fileType ;
private  long size ;
}
