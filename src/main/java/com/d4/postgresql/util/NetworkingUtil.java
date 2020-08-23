package com.d4.postgresql.util;

import javax.servlet.http.HttpServletRequest;

public class NetworkingUtil {

    public static String getIPFromRequest(HttpServletRequest request) {
        // credit: https://www.baeldung.com/spring-security-restrict-authentication-by-geography
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
