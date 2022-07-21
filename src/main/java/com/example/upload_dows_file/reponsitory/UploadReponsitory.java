package com.example.upload_dows_file.reponsitory;

import com.example.upload_dows_file.model.UploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadReponsitory extends JpaRepository<UploadEntity,Integer> {
UploadEntity getById(Integer id );
}
