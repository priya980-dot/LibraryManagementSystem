package com.example.librarymanagementsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.librarymanagementsystem.Dto.AuthorDto;
import com.example.librarymanagementsystem.Dto.AuthorNameDto;
import com.example.librarymanagementsystem.Entity.Author;
import com.example.librarymanagementsystem.Service.AuthorService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService as;

    @GetMapping("/authors")
    public ResponseEntity<List<AuthorNameDto>> getAuthors() {
        List<AuthorNameDto> a = this.as.allAuthor();

        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/author_books/{Id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long Id) {

        return this.as.byid(Id);
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return this.as.save(author);
    }

    // @PutMapping("/updateAuthor")
    // public Author updateAuthor(@RequestBody Author author) {
    // return this.as.save(author);
    // }



}
