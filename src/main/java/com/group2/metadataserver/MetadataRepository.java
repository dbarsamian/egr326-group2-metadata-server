package com.group2.metadataserver;

import org.springframework.data.jpa.repository.JpaRepository;

interface MetadataRepository extends JpaRepository<Metadata, Long> {

}