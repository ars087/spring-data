package com.javaCodeSpringData.SpringDataProjecLibrary.controller;

import com.javaCodeSpringData.SpringDataProjecLibrary.dto.BookDto;
import com.javaCodeSpringData.SpringDataProjecLibrary.mapper.BookMapper;
import com.javaCodeSpringData.SpringDataProjecLibrary.model.Book;
import com.javaCodeSpringData.SpringDataProjecLibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping("/api/books")
    public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }


    @GetMapping
    public ResponseEntity<?> getAllBooks(Pageable pageable) {
        Page<Book> books = bookService.getAllBooks(pageable);
        List<BookDto> bookDtos = books.getContent().stream()
            .map(bookMapper::convertToDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(bookDtos);
    }

        @GetMapping("/{id}")
        public ResponseEntity<Book> getBookById(@PathVariable Long id) {
            return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Book createBook(@Valid @RequestBody Book book) {
            return bookService.createBook(book);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
            try {
                Book updatedBook = bookService.updateBook(id, book);
                return ResponseEntity.ok(updatedBook);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteBook(@PathVariable Long id) {
            bookService.deleteBook(id);
        }

}
