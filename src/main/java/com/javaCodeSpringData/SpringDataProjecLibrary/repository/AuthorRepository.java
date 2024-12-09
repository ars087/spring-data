package com.javaCodeSpringData.SpringDataProjecLibrary.repository;

import com.javaCodeSpringData.SpringDataProjecLibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}