package com.example.FileHandling.controller;

import com.example.FileHandling.dto.DocumentDTO;
import com.example.FileHandling.entity.DocumentEntity;
import com.example.FileHandling.service.DocumentService;
import com.example.FileHandling.util.PdfGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    // ================= Upload =================
    @PostMapping("/upload")
    public ResponseEntity<DocumentDTO> upload(@RequestParam MultipartFile file)
            throws IOException {

        DocumentEntity doc = documentService.uploadFile(file);

        return ResponseEntity.ok(
                new DocumentDTO(
                        doc.getId(),
                        doc.getFileName(),
                        doc.getFileType(),
                        doc.getSize()
                )
        );
    }

    // ================= Download =================
    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id)
            throws MalformedURLException, FileNotFoundException {

        DocumentEntity doc = documentService.getDocument(id);
        Resource resource = new UrlResource(Paths.get(doc.getFilePath()).toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + doc.getFileName() + "\"")
                .body(resource);
    }

    // ================= View Image =================
    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> viewImage(@PathVariable Long id)
            throws MalformedURLException, FileNotFoundException {

        DocumentEntity doc = documentService.getDocument(id);
        Resource resource = new UrlResource(Paths.get(doc.getFilePath()).toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getFileType()))
                .body(resource);
    }

    // ================= Generate PDF =================
    @GetMapping("/generate-pdf")
    public ResponseEntity<Resource> generatePdf() throws Exception {

        String fileName = "report.pdf";
        String path = "uploads/" + fileName;

        PdfGenerator.generate(path);   // ✅ only path passed

        Resource resource = new UrlResource(Paths.get(path).toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

}
