package com.minglemongles.minglejam.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String code;
    private String message;

    public static ExceptionDTO of(ErrorCode errorCode) {
        return new ExceptionDTO(errorCode.name(), errorCode.getMessage());
    }

    public static ExceptionDTO of(String code, String message) {
        return new ExceptionDTO(code, message);
    }
}
