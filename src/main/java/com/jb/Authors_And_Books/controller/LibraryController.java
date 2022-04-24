package com.jb.Authors_And_Books.controller;

import com.jb.Authors_And_Books.beans.Author;
import com.jb.Authors_And_Books.exceptions.LibraryCustomExceptions;
import com.jb.Authors_And_Books.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor(@RequestBody Author author){
        libraryService.addAuthor(author);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthorById(@PathVariable int id) throws LibraryCustomExceptions {
        libraryService.deleteAuthorById(id);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks(){
        return new ResponseEntity<>(libraryService.getAllBooks(),HttpStatus.OK);
    }
    @GetMapping("/getAuthor/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable int id) throws LibraryCustomExceptions {
        return new ResponseEntity<>(libraryService.getAuthorById(id),HttpStatus.OK);
    }
    @GetMapping("/get/{startYear}/{endYear}")
    public ResponseEntity<?> getBooksBetweenYears(@PathVariable int startYear, @PathVariable int endYear) throws LibraryCustomExceptions {
        return new ResponseEntity<>(libraryService.getBooksBetweenYears(startYear,endYear),HttpStatus.OK);
    }
    @GetMapping("/getBooksAvg")
    public ResponseEntity<?> getBooksAvg() throws LibraryCustomExceptions {
        return new ResponseEntity<>(libraryService.avgBookYears(),HttpStatus.OK);
    }
    @GetMapping("/getBooksAvg/{id}")
    public ResponseEntity<?> getBooksAvgByAuthorId(@PathVariable int id) throws LibraryCustomExceptions {
        return new ResponseEntity<>(libraryService.avgBookYearsByAuthorId(id),HttpStatus.OK);
    }







}
