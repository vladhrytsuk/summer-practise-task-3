package com.car.controlles;

import com.car.service.exception.ErrorInfoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorInfoDTO handleValidateException(MethodArgumentNotValidException error)
    {
        ErrorInfoDTO errorDTO = new ErrorInfoDTO(error.getMessage());
        errorDTO.ExceptionHandler();
        return errorDTO;
    }
}
