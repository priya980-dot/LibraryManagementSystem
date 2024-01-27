package com.example.librarymanagementsystem.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagementsystem.Dto.BookDto;
import com.example.librarymanagementsystem.Entity.Author;
import com.example.librarymanagementsystem.Entity.BookEntity;
import com.example.librarymanagementsystem.Entity.Book_Department;
import com.example.librarymanagementsystem.Respository.AuthorRepository;
import com.example.librarymanagementsystem.Respository.DepartmentRepository;
import com.example.librarymanagementsystem.Service.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bs;

    @Autowired
    private AuthorRepository ar;

    @Autowired
    private DepartmentRepository dr;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks(@RequestParam String param) {
        List<BookDto> b = this.bs.findAll();
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @GetMapping("/getBook/{Book_Id}")
    public BookDto getBookById(@PathVariable Long Id) {
        return this.bs.byid(Id);
    }

    @PostMapping("/addbook")
    public ResponseEntity<String> addBooks(@RequestBody BookEntity book,
            @RequestParam Long authorId,
            @RequestParam Long departmentId) {
        Optional<Author> Opauthor = this.ar.findById(authorId);
        Optional<Book_Department> Opbood_dep = this.dr.findById(departmentId);
        if (Opauthor.isPresent() && Opbood_dep.isPresent()) {
            Author a = Opauthor.get();
            Book_Department b = Opbood_dep.get();
            book.setAuthors(new HashSet<>(Collections.singletonList(a)));
            book.setDepartment(new HashSet<>(Collections.singletonList(b)));
            bs.save(book);
            return ResponseEntity.ok("Book added successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author or Department not found.");
        }
    }

    // @PutMapping("/updatebook/{id}")
    // public BookEntity updateBookdetail(@PathVariable("id") Integer id,
    // @RequestBody BookEntity book) {

    // return bs.save(book);
    // }

}

