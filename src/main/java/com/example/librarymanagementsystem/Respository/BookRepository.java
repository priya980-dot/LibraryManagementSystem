package com.example.librarymanagementsystem.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.Entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long>{


}
