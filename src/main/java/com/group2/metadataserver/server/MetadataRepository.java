package com.group2.metadataserver.server;

import com.group2.metadataserver.model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

interface MetadataRepository extends JpaRepository<Metadata, Long> {

}