package com.example.trial.services.impl;

import com.example.trial.config.FileStorageConfig;
import com.example.trial.services.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * The type File storage service.
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageService.class);

    /**
     * The File storage location.
     */
    private Path fileStorageLocation;

    /**
     * The File storage config.
     */
    @Autowired
    FileStorageConfig fileStorageConfig;

    @Override
    public String storeFile(MultipartFile file) {

        final String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path targetLocation = null;
        try {
           fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath()
                   .normalize();
            Files.createDirectories(this.fileStorageLocation);
            if(!fileName.contains("..")) {
                targetLocation = this.fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            LOGGER.error("Error While Saving File: {}",ex.getMessage());
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!");
        }
        return targetLocation.toString();
    }
}
