package com.example.librarymanagementsystem.Entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Author_table")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Author_Id;
    @Column(name = "name", unique = true, nullable = false)
    String Author_name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, mappedBy = "authors")
    private Set<BookEntity> books=new HashSet<>();



    public Author(String name){
        this.Author_name=name;
    }
}


