package com.example.librarymanagementsystem.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.Dto.AuthorDto;
import com.example.librarymanagementsystem.Dto.AuthorNameDto;
import com.example.librarymanagementsystem.Entity.Author;
import com.example.librarymanagementsystem.Entity.BookEntity;
import com.example.librarymanagementsystem.Respository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository ar;

    //   @Autowired
    // private ModelMapper modelMapper;

    public List<AuthorNameDto> allAuthor(){
        System.err.println(" ");
        List<Author> aa= this.ar.findAll();
        List<AuthorNameDto> btl=new ArrayList<>();
	

		for(Author b:aa) {
            AuthorNameDto ad=new AuthorNameDto();
			//AuthorDto bd=modelMapper.map(b, AuthorDto.class);
			ad.setAuthorName(b.getAuthor_name());
			btl.add(ad);}
            return btl;
    }


    public ResponseEntity<AuthorDto> byid(Long i){
        Optional<Author> aa= this.ar.findById(i);
        if(!aa.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
        AuthorDto ad=new AuthorDto();
        ad.setAuthor_name(aa.get().getAuthor_name());
        
        Set<String> bookNames = aa.get().getBooks().stream()
                .map(BookEntity::getBook_name)  // Assuming your BookEntity has a method like getBookName()
                .collect(Collectors.toSet());

        ad.setBooks(bookNames);


        System.err.println(aa.get().getBooks());
          return ResponseEntity.ok(ad);}
        
    }

  

    public Author save(Author author){
        if (author.getAuthor_name() != null) {
            return ar.save(author);
        } else {
            // Handle the case where Author_name is null
            throw new IllegalArgumentException("Author_name cannot be null");
        }
    }

    
}
