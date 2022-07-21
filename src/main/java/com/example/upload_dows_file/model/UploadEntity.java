package com.example.upload_dows_file.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "uploads")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UploadEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id ;
    private String filename ;
    private String fileUrl ;
    private String fileType ;

    public UploadEntity(String filename, String fileUrl, String fileType) {
        this.filename = filename;
        this.fileUrl = fileUrl;
        this.fileType = fileType;
    }
}

