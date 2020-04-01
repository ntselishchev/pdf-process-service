package com.ntselishchev.processpdf.rest;

import com.ntselishchev.processpdf.service.PdfProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequiredArgsConstructor
public class PdfController {

    private final PdfProcessingService pdfProcessingService;

    @PostMapping("/pdf")
    public void processPdf(@RequestBody String content, HttpServletRequest request, HttpServletResponse response)  {
        pdfProcessingService.processPdf(content, request, response);
    }

}
