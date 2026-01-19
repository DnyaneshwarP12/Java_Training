package com.example.FileHandling.service;

import com.example.FileHandling.entity.DocumentEntity;
import com.example.FileHandling.exception.FileStorageException;
import com.example.FileHandling.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    private static final Set<String> ALLOWED_TYPES =
            Set.of("image/png", "image/jpeg", "application/pdf");

    public DocumentEntity uploadFile(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new FileStorageException("File is empty");
        }

        if (file.getSize() > 5 * 1024 * 1024) {
            throw new FileStorageException("File size exceeds 5MB");
        }

        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            throw new FileStorageException("Invalid file type");
        }

        Path root = Paths.get(uploadDir);
        Files.createDirectories(root);

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = root.resolve(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        DocumentEntity doc = new DocumentEntity();
        doc.setFileName(fileName);
        doc.setFileType(file.getContentType());
        doc.setSize(file.getSize());
        doc.setFilePath(filePath.toString());
        doc.setUploadedAt(LocalDateTime.now());

        return documentRepository.save(doc);
    }

    public DocumentEntity getDocument(Long id) throws FileNotFoundException {
        return documentRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("File not found with id: " + id));
    }
}
