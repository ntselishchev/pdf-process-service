package com.ntselishchev.processpdf.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class ServletResponseService {

    private static final String CONTENT_HEADER = "Content-Disposition";
    private static final String PDF_CONTENT_TYPE = "application/pdf";
    private static final String PDF_EXTENSION = "pdf";

    public void fillPdfProperties(HttpServletResponse response, String fileName) {
        response.setHeader(CONTENT_HEADER, setContentHeaderType(fileName));
        response.setContentType(PDF_CONTENT_TYPE);
    }

    private String setContentHeaderType(String fileName) {
        return String.format("attachment; filename=%s.%s", fileName, PDF_EXTENSION);
    }

    public void writeByteArrayResponse(HttpServletResponse response, byte[] decodedBytes) throws IOException {
        response.getOutputStream().write(decodedBytes);
        response.getOutputStream().close();
    }
}
