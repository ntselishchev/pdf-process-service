package com.ntselishchev.processpdf.rest;

import com.ntselishchev.processpdf.service.PdfProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class PdfController {

    private final PdfProcessingService pdfProcessingService;

    @PostMapping("/pdf-body")
    public void processPdf(@RequestBody String content, HttpServletRequest request, HttpServletResponse response) throws IOException {
        pdfProcessingService.processPdf(content, request, response);
    }

    @PostMapping("/pdf")
    public void processPdf(HttpServletRequest request, HttpServletResponse response) throws IOException {
        pdfProcessingService.processPdf(null, request, response);
    }
}

