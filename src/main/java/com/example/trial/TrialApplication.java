package com.example.trial;

import com.example.trial.config.FileStorageConfig;
import com.example.trial.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageConfig.class})
public class TrialApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrialApplication.class, args);
  }

}
