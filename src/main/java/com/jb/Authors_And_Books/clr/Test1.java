package com.jb.Authors_And_Books.clr;

import com.jb.Authors_And_Books.beans.Author;
import com.jb.Authors_And_Books.beans.Book;
import com.jb.Authors_And_Books.repositories.AuthorRepo;
import com.jb.Authors_And_Books.repositories.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@RequiredArgsConstructor
@Order(1)
public class Test1 implements CommandLineRunner {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    @Override
    public void run(String... args) throws Exception {
      Book book1 = Book.builder()
              .name("harry potter")
              .year(2004)
              .build();
        Book book2 = Book.builder()
                .name("4 agreements")
                .year(2018)
                .build();
        Book book3 = Book.builder()
                .name("Tom and Jerry")
                .year(2010)
                .build();
        Book book4 = Book.builder()
                .name("chemistry book")
                .year(2010)
                .build();

        Author author1 = Author.builder()
                .name("John")
                .books(List.of(book1,book2))
                .weight(72)
                .build();
        Author author2 = Author.builder()
                .name("David")
                .books(List.of(book3,book4))
                .weight(66.5f)
                .build();
        authorRepo.saveAll(List.of(author1,author2));




    }
}
