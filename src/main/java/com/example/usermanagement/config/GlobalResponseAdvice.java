package com.example.usermanagement.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.example.usermanagement.dto.ApiResponse;

@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {
    // @Override
    // public boolean supports(
    //         MethodParameter returnType,
    //         Class<? extends HttpMessageConverter<?>> converterType) {
    //     Class<?> returnClass = returnType.getParameterType();
    //     return !ApiResponse.class.isAssignableFrom(returnType.getParameterType())
    //             && !ResponseEntity.class.isAssignableFrom(returnType.getParameterType())
    //             && !ValidationErrorResponse.class.isAssignableFrom(returnClass);
    // }

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    // @Override
    // public Object beforeBodyWrite(
    //         Object body,
    //         MethodParameter returnType,
    //         MediaType selectedContentType,
    //         Class<? extends HttpMessageConverter<?>> selectedConverterType,
    //         ServerHttpRequest request,
    //         ServerHttpResponse response) {

    //     String path = request.getURI().getPath();
    //     if (path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui")) {
    //         return body;
    //     }

    //     if (body instanceof ApiResponse) {
    //         return body;
    //     }
        
    //     if (body == null) {
    //         return ApiResponse.success();
    //     }

    //     return ApiResponse.success(body);
    // }

     @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        String path = request.getURI().getPath();

        // 🔥 EXCLUDE SWAGGER & OPENAPI TOTAL
        if (path.startsWith("/v3/api-docs")
                || path.startsWith("/swagger-ui")) {
            return body;
        }

        // avoid double wrapping
        if (body instanceof ApiResponse) {
            return body;
        }

        if (body == null) {
            return ApiResponse.success();
        }

        return ApiResponse.success(body);
    }
}
