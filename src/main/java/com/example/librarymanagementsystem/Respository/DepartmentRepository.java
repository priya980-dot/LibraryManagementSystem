package com.example.librarymanagementsystem.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.Entity.Book_Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Book_Department,Long>{
   
}