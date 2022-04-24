package com.jb.Authors_And_Books.service;

import com.jb.Authors_And_Books.beans.Author;
import com.jb.Authors_And_Books.beans.Book;
import com.jb.Authors_And_Books.exceptions.LibraryCustomExceptions;
import com.jb.Authors_And_Books.repositories.AuthorRepo;
import com.jb.Authors_And_Books.repositories.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public void addAuthor(Author author){
        authorRepo.save(author);
        System.out.println("author saved successfully");
    }
    public void deleteAuthorById(int id) throws LibraryCustomExceptions {
        if(!authorRepo.existsById(id)){
            throw new LibraryCustomExceptions("author not exists");
        }
        authorRepo.deleteById(id);
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Author getAuthorById(int id) throws LibraryCustomExceptions {
        if(!authorRepo.existsById(id)){
            throw new LibraryCustomExceptions("author not exists");
        } return authorRepo.findById(id).get();
    }

    public List<Book> getBooksBetweenYears(int startYear, int endYear) throws LibraryCustomExceptions {
        if(startYear>endYear){
            throw new LibraryCustomExceptions("start year must be lower than end year!");
        }
        return bookRepo.findByYearBetween(startYear,endYear);
    }

    public double avgBookYears() throws LibraryCustomExceptions {
       return bookRepo.avg();
    }
    public double avgBookYearsByAuthorId(int id) throws LibraryCustomExceptions {
      return bookRepo.avgByAuthorId(id);

    }



    }
