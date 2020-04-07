package com.ntselishchev.processpdf.service;

import com.ntselishchev.processpdf.util.ContentUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PdfProcessingService {

    private final ServletResponseService servletResponseService;
    private final ServletRequestService servletRequestService;

    public void processPdf(String encodedString, HttpServletRequest request, HttpServletResponse response) throws IOException {

        byte[] decodedBytes;

        if (encodedString == null) {
            decodedBytes = IOUtils.toByteArray(request.getInputStream());
        } else {
            decodedBytes = ContentUtils.decodeStringToByteArray(encodedString);
        }

        // TODO invoke cryptoPRO here

        String fileName = servletRequestService.getFileNameFromHeader(request);
        servletResponseService.fillPdfProperties(response, fileName);

        try {
            servletResponseService.writeByteArrayResponse(response, decodedBytes);
            log.info("file {} has been processed successfully", fileName);
        } catch (IOException e) {
            log.error("unable to write file {}", fileName, e);
        }
    }
}
