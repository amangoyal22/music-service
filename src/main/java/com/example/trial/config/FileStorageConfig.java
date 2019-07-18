package com.example.trial.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type File storage config.
 */
@ConfigurationProperties(prefix = "spring.file")
public class FileStorageConfig {

    private String uploadDir;

    /**
     * Gets upload dir.
     *
     * @return the upload dir
     */
    public String getUploadDir() {
        return uploadDir;
    }

    /**
     * Sets upload dir.
     *
     * @param uploadDir the upload dir
     */
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

}
