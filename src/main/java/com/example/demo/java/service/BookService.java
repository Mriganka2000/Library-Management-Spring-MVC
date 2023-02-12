package com.example.demo.java.service;

import com.example.demo.java.business.bean.BookBean;

import java.util.List;

public interface BookService {

    List<BookBean> findAllBooks();

    BookBean findByBookId(Long id);

    Long saveNewBook(BookBean bookBean);

    BookBean updateBook(BookBean bookBean);

    void deleteBook(Long id);

    List<BookBean> searchByKeyword(String keyword);

}
