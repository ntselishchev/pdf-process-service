package com.ntselishchev.processpdf.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class ServletRequestService {

    private static final String CONTENT_HEADER = "Content-Disposition";
    private static final String DEFAULT_FN = "DEFAULT_FILE_NAME";

    public String getFileNameFromHeader(HttpServletRequest request) {
        String header = request.getHeader(CONTENT_HEADER);
        return StringUtils.isEmpty(header) ? DEFAULT_FN : header.replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
    }
}
