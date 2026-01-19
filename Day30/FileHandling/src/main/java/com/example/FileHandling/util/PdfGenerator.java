package com.example.FileHandling.util;

import com.example.FileHandling.entity.DocumentEntity;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.time.LocalDate;

import com.itextpdf.text.Document;

public class PdfGenerator {

    public static void generate(String filePath) throws Exception {

        Document pdfDocument = new Document(); // ✅ iText Document ONLY
        PdfWriter.getInstance(pdfDocument, new FileOutputStream(filePath));

        pdfDocument.open();
        pdfDocument.add(new Paragraph("Document Management Report"));
        pdfDocument.add(new Paragraph("Generated on: " + LocalDate.now()));
        pdfDocument.close();
    }
}

