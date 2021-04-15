package com.group2.metadataserver;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Metadata {
    private @Id @GeneratedValue Long id;

    public Metadata() {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSizeInKb() {
        return fileSizeInKb;
    }

    public void setFileSizeInKb(Long fileSizeInKb) {
        this.fileSizeInKb = fileSizeInKb;
    }

    private String fileName;
    private Long fileSizeInKb;

    Metadata(String fileName, Long fileSizeInKb) {
        this.fileName = fileName;
        this.fileSizeInKb = fileSizeInKb;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Metadata)) return false;
        Metadata metadata = (Metadata) obj;
        return Objects.equals(this.id, metadata.id)
                && Objects.equals(this.fileName, metadata.fileName)
                && Objects.equals(this.fileSizeInKb, metadata.fileSizeInKb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.fileName, this.fileSizeInKb);
    }

    @Override
    public String toString() {
        return "Metadata{"
                + "id=" + this.id
                + ", fileName='" + this.fileName + '\''
                + ", fileSizeInKb='" + this.fileSizeInKb + '\'' + '}';
    }
}
