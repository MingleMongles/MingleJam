package com.minglemongles.minglejam.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minglemongles.minglejam.common.exception.CommonException;
import com.minglemongles.minglejam.common.exception.ErrorCode;
import com.minglemongles.minglejam.common.exception.ExceptionDTO;
import jakarta.annotation.Nullable;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Data
public class ResponseDTO<T> {

    @JsonIgnore
    private HttpStatus httpStatus;

    private boolean success;

    @Nullable
    private T data;

    @Nullable
    private ExceptionDTO error;

    public ResponseDTO() {
    }

    public ResponseDTO(HttpStatus httpStatus, boolean success, @Nullable T data, @Nullable ExceptionDTO error) {
        this.httpStatus = httpStatus;
        this.success = success;
        this.data = data;
        this.error = error;
    }

    // 성공 응답
    public static <T> ResponseDTO<T> ok(T data) {
        return new ResponseDTO<>(HttpStatus.OK, true, data, null);
    }

    // 실패 응답 - CommonException 기반
    public static ResponseDTO<Object> fail(CommonException e) {
        return new ResponseDTO<>(
                e.getErrorCode().getHttpStatus(),
                false,
                null,
                ExceptionDTO.of(e.getErrorCode())
        );
    }

    // 실패 응답 - 메시지 기반
    public static ResponseDTO<Object> fail(String message) {
        return new ResponseDTO<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                false,
                null,
                ExceptionDTO.of("INTERNAL_SERVER_ERROR", message)
        );
    }

    // 실패 응답 - 메시지 + 상태코드
    public static ResponseDTO<Object> fail(HttpStatus status, String message) {
        return new ResponseDTO<>(
                status,
                false,
                null,
                ExceptionDTO.of(status.name(), message)
        );
    }

    // 실패 응답 - MissingServletRequestParameterException
    public static ResponseDTO<Object> fail(MissingServletRequestParameterException e, Object data) {
        return new ResponseDTO<>(
                HttpStatus.BAD_REQUEST,
                false,
                data,
                ExceptionDTO.of(ErrorCode.MISSING_REQUEST_PARAMETER.name(), e.getMessage())
        );
    }

    // 실패 응답 - MethodArgumentTypeMismatchException
    public static ResponseDTO<Object> fail(MethodArgumentTypeMismatchException e, Object data) {
        return new ResponseDTO<>(
                HttpStatus.BAD_REQUEST,
                false,
                data,
                ExceptionDTO.of(ErrorCode.INVALID_PARAMETER_FORMAT.name(), e.getMessage())
        );
    }
}
