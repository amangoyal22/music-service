package com.example.trial.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * The interface File storage service.
 */
public interface FileStorageService {

    /**
     * Store file list.
     *
     * @param file the file
     * @return the list
     */
    String storeFile(MultipartFile file);

}
