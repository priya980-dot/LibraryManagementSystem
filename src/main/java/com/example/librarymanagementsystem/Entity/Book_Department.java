package com.example.librarymanagementsystem.Entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Department_table")
public class Book_Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dep_id;

    @Column(name = "name",  nullable = false, unique = true)
    private String dep_name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "department")
    private Set<BookEntity> books=new HashSet<>();

public Book_Department(String name){
    this.dep_name=name;
}

}
