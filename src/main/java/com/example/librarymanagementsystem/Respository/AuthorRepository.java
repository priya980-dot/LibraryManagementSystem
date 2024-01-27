package com.example.librarymanagementsystem.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{

  
}