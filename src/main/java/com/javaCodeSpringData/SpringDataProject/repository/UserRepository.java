package com.javaCodeSpringData.SpringDataProject.repository;

import com.javaCodeSpringData.SpringDataProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
