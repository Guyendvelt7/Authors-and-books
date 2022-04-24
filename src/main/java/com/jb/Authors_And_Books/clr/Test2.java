package com.jb.Authors_And_Books.clr;

import com.jb.Authors_And_Books.beans.Author;
import com.jb.Authors_And_Books.beans.Book;
import com.jb.Authors_And_Books.service.LibraryService;
import javafx.beans.binding.DoubleExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
//Rest Template checkes
@Component
@RequiredArgsConstructor
@Order(2)
public class Test2 implements CommandLineRunner {
    private final LibraryService libraryService;
    private final RestTemplate restTemplate;
    @Override
    public void run(String... args) throws Exception {
        //first Check
       Author author = restTemplate.getForObject("http://localhost:8080/getAuthor/1", Author.class);
        System.out.println(author);
        //Second Check
        List<Book> bookList = restTemplate.getForObject("http://localhost:8080/getAllBooks",List.class);
        System.out.println(bookList);

        //Third check
        List<Book> books = restTemplate.getForObject("http://localhost:8080/get/2005/2014",List.class);
        System.out.println(books);

        //4th check
        double avg = restTemplate.getForObject("http://localhost:8080/getBooksAvg", Double.class);
        System.out.println("the books average is -> " + avg);

        double booksAvgById = restTemplate.getForObject("http://localhost:8080/getBooksAvg/1",Double.class);
        System.out.println(booksAvgById);


    }
}
