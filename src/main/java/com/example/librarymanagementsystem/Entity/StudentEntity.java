package com.example.librarymanagementsystem.Entity;

import java.math.BigInteger;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Student_table")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Stu_Id;
    @Column(nullable = false)
    String first_name;
    String last_name;
    String gender;
    BigInteger mobile;
    String Address;
    Boolean borrowOrnot = false;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private List<StudentBookRelation> studentBookRelations;

    public StudentEntity(String first_name, String last_name, String gender, BigInteger mobile, 
            String Address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.mobile = mobile;
      // this.DOB = convertStringToDate(DOB);
        this.Address = Address;
    }

    // private Date convertStringToDate(String dateString) {
    //     try {
    //         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    //         java.util.Date parsedDate = format.parse(dateString);
    //         return new Date(parsedDate.getTime());
    //     } catch (ParseException e) {
    //         // Handle the exception or log it
    //         return null;
    //     }
    // }


}

