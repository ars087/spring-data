package com.javaCodeSpringData.SpringDataProjecLibrary.dto;


public class BookDto {
    private Long id;
    private String title;
    private String genre;

    private AuthorDto author;

    public BookDto(Long id, String title, AuthorDto author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

public BookDto(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
