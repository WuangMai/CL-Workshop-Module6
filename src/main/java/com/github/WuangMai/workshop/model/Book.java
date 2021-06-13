package com.github.WuangMai.workshop.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "books")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 13)
    private String isbn;

    private String title;
    private String author;
    private String publisher;
    private String type;

}
