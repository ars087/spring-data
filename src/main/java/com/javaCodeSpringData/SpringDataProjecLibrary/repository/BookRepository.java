package com.javaCodeSpringData.SpringDataProjecLibrary.repository;


import com.javaCodeSpringData.SpringDataProjecLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends JpaRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {

}