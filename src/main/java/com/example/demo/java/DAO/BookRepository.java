package com.example.demo.java.DAO;

import com.example.demo.java.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT b FROM BookEntity b WHERE b.id = ?1")
    BookEntity findBookById(Long id);

    @Query("SELECT b FROM BookEntity b WHERE b.name LIKE '%' || :keyword || '%' " +
            "OR b.publisherName LIKE '%' || :keyword || '%' OR b.authorName LIKE '%' || :keyword || '%'")
    List<BookEntity> searchBookEntityByKeyword(String keyword);

}
