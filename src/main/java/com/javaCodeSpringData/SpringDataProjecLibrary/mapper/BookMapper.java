package com.javaCodeSpringData.SpringDataProjecLibrary.mapper;

import com.javaCodeSpringData.SpringDataProjecLibrary.dto.AuthorDto;
import com.javaCodeSpringData.SpringDataProjecLibrary.dto.BookDto;
import com.javaCodeSpringData.SpringDataProjecLibrary.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public BookDto convertToDto(Book book) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(book.getAuthor().getId());
        authorDto.setName(book.getAuthor().getName());

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setGenre(book.getGenre());
        bookDto.setAuthor(authorDto);

        return bookDto;
    }
}
