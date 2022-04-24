package com.jb.Authors_And_Books.repositories;

import com.jb.Authors_And_Books.beans.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findByYearBetween(int startYear, int endYear);
    @Query(value = "SELECT AVG(year) FROM authors_and_books.book" ,nativeQuery = true)
    double avg();

    @Query( value = "SELECT AVG(year) FROM authors_and_books.book WHERE id=any " +
            "(SELECT books_id FROM authors_and_books.author_books WHERE author_id=?1)",nativeQuery = true)
    double avgByAuthorId(int id);
}
