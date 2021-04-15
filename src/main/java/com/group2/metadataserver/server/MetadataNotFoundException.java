package com.group2.metadataserver;

public class MetadataNotFoundException extends RuntimeException {
    MetadataNotFoundException(Long id) {
        super("Could not find metadata " + id);
    }
}
