package com.jb.Authors_And_Books.repositories;

import com.jb.Authors_And_Books.beans.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
