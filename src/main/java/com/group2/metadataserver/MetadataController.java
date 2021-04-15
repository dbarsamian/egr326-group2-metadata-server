package com.group2.metadataserver;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetadataController {
    private final MetadataRepository repository;

    public MetadataController(MetadataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/allMetadata")
    List<Metadata> all() {
        return repository.findAll();
    }

    @PostMapping("/metadata")
    Metadata newMetadata(@RequestBody Metadata newMetadata) {
        return repository.save(newMetadata);
    }

    @GetMapping("/metadata/{id}")
    Metadata one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MetadataNotFoundException(id));
    }

    @PutMapping("/metadata/{id}")
    Metadata replace(@RequestBody Metadata newMetadata, @PathVariable Long id) {
        return repository.findById(id)
                .map(metadata -> {
                    metadata.setFileName(newMetadata.getFileName());
                    metadata.setFileSizeInKb(newMetadata.getFileSizeInKb());
                    return repository.save(metadata);
                })
                .orElseGet(() -> {
                    newMetadata.setId(id);
                    return repository.save(newMetadata);
                });
    }

    @DeleteMapping("/metadata/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
