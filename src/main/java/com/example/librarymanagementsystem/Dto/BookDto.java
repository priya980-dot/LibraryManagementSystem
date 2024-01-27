package com.example.librarymanagementsystem.Dto;

import java.util.*;
import org.codehaus.jackson.annotate.JsonProperty;

import com.example.librarymanagementsystem.Entity.Author;
import com.example.librarymanagementsystem.Entity.Book_Department;

import lombok.*;

@Getter
@Setter
public class BookDto {
    @JsonProperty("name")
    String book_name;

    @JsonProperty("BorrowedOrNot")
    Boolean borrowedOrNot;
    
    @JsonProperty("department")
    Set<Book_Department> department;

    @JsonProperty("author")
    Set<Author> authors;
}
