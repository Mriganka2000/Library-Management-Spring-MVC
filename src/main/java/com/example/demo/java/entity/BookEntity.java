package com.example.demo.java.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "book_price")
    private Double price;

    public BookEntity(String name, String publisherName, Integer pages, String authorName, Double price) {
        this.name = name;
        this.publisherName = publisherName;
        this.pages = pages;
        this.authorName = authorName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", pages=" + pages +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}';
    }

}
