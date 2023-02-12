package com.example.demo.java.business.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBean {

    private Long id;
    private String name;
    private String publisherName;
    private Integer pages;
    private String authorName;
    private Double price;

    public BookBean() {
    }

    public BookBean(String name, String publisherName, Integer pages, String authorName, Double price) {
        this.name = name;
        this.publisherName = publisherName;
        this.pages = pages;
        this.authorName = authorName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", pages=" + pages +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                '}';
    }

}

