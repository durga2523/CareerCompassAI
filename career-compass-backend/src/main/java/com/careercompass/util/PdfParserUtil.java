package com.careercompass.util;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class PdfParserUtil {

    public static String extractText(MultipartFile file) {

        try {

            PDDocument document = Loader.loadPDF(file.getBytes());

            PDFTextStripper pdfTextStripper = new PDFTextStripper();

            String text = pdfTextStripper.getText(document);

            document.close();

            return text;

        } catch (IOException e) {
            throw new RuntimeException("Unable to read PDF: " + e.getMessage());
        }
    }


    public static String extractText(String filePath) {

        try {
            PDDocument document = Loader.loadPDF(new File(filePath));

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            document.close();

            return text;

        } catch (IOException e) {
            throw new RuntimeException("Failed to extract PDF text");
        }
    }
}