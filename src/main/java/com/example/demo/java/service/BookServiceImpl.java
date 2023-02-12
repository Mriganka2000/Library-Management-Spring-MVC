package com.example.demo.java.service;

import com.example.demo.java.DAO.BookDAOWrapper;
import com.example.demo.java.business.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAOWrapper bookDAOWrapper;

    @Override
    public List<BookBean> findAllBooks() {
        return bookDAOWrapper.findAllBooks();
    }

    @Override
    public BookBean findByBookId(Long id) {
        return bookDAOWrapper.findByBookId(id);
    }

    @Override
    public Long saveNewBook(BookBean bookBean) {
        return bookDAOWrapper.saveNewBook(bookBean);
    }

    @Override
    public BookBean updateBook(BookBean bookBean) {
        return bookDAOWrapper.updateBook(bookBean);
    }

    @Override
    public void deleteBook(Long id) {
        bookDAOWrapper.deleteBook(id);
    }

    @Override
    public List<BookBean> searchByKeyword(String keyword) {
        return bookDAOWrapper.searchByKeyword(keyword);
    }

}
