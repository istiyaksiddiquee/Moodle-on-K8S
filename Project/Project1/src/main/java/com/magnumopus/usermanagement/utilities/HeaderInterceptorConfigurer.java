package com.magnumopus.usermanagement.utilities;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Configuration
public class HeaderInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor());
    }
}

class HeaderInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Enumeration<String> headerNameEnumerator = request.getHeaderNames();

        while (headerNameEnumerator.hasMoreElements()) {
            String headerName = headerNameEnumerator.nextElement();
            if (headerName.startsWith("x-")) {
                response.setHeader(headerName, request.getHeader(headerName));
            }
        }

        return true;
    }
}