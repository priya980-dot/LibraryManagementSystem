package com.example.librarymanagementsystem.Entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Book_table")
public class BookEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Book_Id;
    @Column(unique = true)
    String book_name;
    
Boolean borrowedOrno=false ;
@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
@JoinTable(name = "books_dep", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
        @JoinColumn(name = "dep_id") })
    private Set<Book_Department> department= new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
            private Set<Author> authors=new HashSet<>();



    public BookEntity(String name,Boolean borrowedOrNot){
        this.book_name=name;
        this.borrowedOrno=borrowedOrNot;
    }        
}

