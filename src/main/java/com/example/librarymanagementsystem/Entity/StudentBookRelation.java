package com.example.librarymanagementsystem.Entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;
 

@Entity
@Table(name = "student_book_relation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentBookRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    private LocalDate borrowDate;
    private LocalDate Expected_ReturnDate;
    private LocalDate returnDate;


    public StudentBookRelation(StudentEntity student,BookEntity book){
        this.book=book;
        this.student=student;

    }
}

