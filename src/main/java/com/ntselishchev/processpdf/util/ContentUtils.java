package com.ntselishchev.processpdf.util;

import java.util.Base64;

public class ContentUtils {

    private ContentUtils() {
    }

    public static byte[] decodeStringToByteArray(String encodedContent) {
        return Base64.getDecoder().decode(encodedContent);
    }

    public static String decodeStringToString(String encodedContent) {
        byte[] decodedBytes = decodeStringToByteArray(encodedContent);
        return new String(decodedBytes);
    }
}
