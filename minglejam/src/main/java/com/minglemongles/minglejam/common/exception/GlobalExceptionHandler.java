package com.minglemongles.minglejam.common.exception;

import com.minglemongles.minglejam.common.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice(basePackages = "com.minglemongles.minglejam")
public class GlobalExceptionHandler {

    @ExceptionHandler({NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseDTO<?> handleNoPageFoundException(Exception e) {
        log.error("NoHandlerFoundException or HttpRequestMethodNotSupportedException: {}", e.getMessage());
        return ResponseDTO.fail(HttpStatus.NOT_FOUND, "잘못된 요청 경로입니다.");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseDTO<?> handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        log.error("MethodArgumentTypeMismatchException: {}", e.getMessage());
        return ResponseDTO.fail(HttpStatus.BAD_REQUEST, "요청 파라미터 형식이 잘못되었습니다.");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseDTO<?> handleMissingParameter(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException: {}", e.getMessage());
        return ResponseDTO.fail(HttpStatus.BAD_REQUEST, "필수 요청 파라미터가 누락되었습니다.");
    }

    @ExceptionHandler(CommonException.class)
    public ResponseDTO<?> handleCustomException(CommonException e) {
        log.error("CommonException: {}", e.getMessage());
        return ResponseDTO.fail(e.getErrorCode().getHttpStatus(), e.getErrorCode().getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseDTO<?> handleGeneralException(Exception e) {
        log.error("Unhandled Exception: {}", e.getMessage(), e);
        return ResponseDTO.fail(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다.");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseDTO<?> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        log.error("DataIntegrityViolationException: {}", e.getMessage());
        return ResponseDTO.fail(HttpStatus.BAD_REQUEST, "데이터 무결성 제약 조건에 위배되었습니다.");
    }
}
