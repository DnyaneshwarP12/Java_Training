package com.example.FileHandling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentDTO {
    private Long id;
    private String fileName;
    private String fileType;
    private long size;
}
