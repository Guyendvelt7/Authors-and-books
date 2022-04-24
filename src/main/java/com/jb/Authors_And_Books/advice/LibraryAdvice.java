package com.jb.Authors_And_Books.advice;

import com.jb.Authors_And_Books.controller.LibraryController;
import com.jb.Authors_And_Books.exceptions.LibraryCustomExceptions;
import com.jb.Authors_And_Books.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class LibraryAdvice {

    @ExceptionHandler(value = {LibraryCustomExceptions.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetails handleLibraryExceptions(Exception exception){
        return new ErrorDetails("Library Error", exception.getMessage());
    }
}
