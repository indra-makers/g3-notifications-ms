package com.co.indra.coinmarketcap.notifications.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.co.indra.coinmarketcap.notifications.model.responses.ErrorResponse;

import org.springframework.http.HttpStatus;
@ControllerAdvice
public class CustomExceptionHandler {

   @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
   @ResponseBody
   @ExceptionHandler(BusinessExceptions.class)
   public ErrorResponse handleBusinessException(BusinessExceptions exception) {
       return new ErrorResponse(exception.getCode(), exception.getMessage());
   }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException exception) {
        return new ErrorResponse("NOT_FOUND", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleNotFoundException(MethodArgumentNotValidException exception) {
        return new ErrorResponse("BAD_REQUEST", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception exception) {
        return new ErrorResponse("500", exception.getMessage());
    }
} 