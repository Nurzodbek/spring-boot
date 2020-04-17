package com.spring.repository;


import com.spring.domain.FileStorage;
import com.spring.domain.FileStorageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage,Long> {

    FileStorage findByHashId(String hashId);

    List<FileStorage> findAllByFileStorageStatus(FileStorageStatus status);
}
