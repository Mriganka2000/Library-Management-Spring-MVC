package com.example.demo.java.DAO;

import com.example.demo.java.business.bean.BookBean;
import com.example.demo.java.entity.BookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
@Transactional
public class BookDAOWrapper {

    @Autowired
    private BookRepository bookRepository;

    public List<BookBean> findAllBooks() {
        List<BookBean> books = new LinkedList<>();
        Iterable<BookEntity> allBooks = bookRepository.findAll();

        allBooks.forEach(entity -> {
            BookBean bookBean = new BookBean();
            convertBookEntityToBean(entity, bookBean);
            books.add(bookBean);
        });

        return books;
    }

    public BookBean findByBookId(Long id) {
        BookEntity bookEntity = bookRepository.findBookById(id);
        BookBean bookBean = new BookBean();

        convertBookEntityToBean(bookEntity, bookBean);

        return bookBean;
    }

    public Long saveNewBook(BookBean bookBean) {
        BookEntity bookEntity = new BookEntity();

        convertBookBeanToEntity(bookBean, bookEntity);
        Long id = bookRepository.save(bookEntity).getId();

        return id;
    }

    public BookBean updateBook(BookBean bookBean) {
        BookEntity bookEntity = new BookEntity();
        convertBookBeanToEntity(bookBean, bookEntity);

        BookEntity entity = bookRepository.save(bookEntity);
        BookBean bean = new BookBean();

        convertBookEntityToBean(entity, bean);

        return bean;
    }

    public void deleteBook(Long id) {
        BookEntity bookEntity = bookRepository.findBookById(id);
        bookRepository.delete(bookEntity);
    }

    public List<BookBean> searchByKeyword(String keyword) {
        List<BookEntity> bookEntities = bookRepository.searchBookEntityByKeyword(keyword);
        List<BookBean> bookBeans = new LinkedList<>();

        bookEntities.forEach(bookEntity -> {
            BookBean bookBean = new BookBean();
            convertBookEntityToBean(bookEntity, bookBean);
            bookBeans.add(bookBean);
        });

        return bookBeans;
    }

    private BookBean convertBookEntityToBean(BookEntity entity, BookBean bean) {
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    private BookEntity convertBookBeanToEntity(BookBean bean, BookEntity entity) {
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

}
