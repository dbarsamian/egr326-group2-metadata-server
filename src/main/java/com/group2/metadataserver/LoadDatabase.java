package com.group2.metadataserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(MetadataRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Metadata("Test Small File", 40L)));
            log.info("Preloading " + repository.save(new Metadata("Test Large File", 12500000L)));
        };
    }
}