package com.example.librarymanagementsystem.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.librarymanagementsystem.Dto.StudentDto;
import com.example.librarymanagementsystem.Entity.BookEntity;
import com.example.librarymanagementsystem.Entity.StudentBookRelation;
import com.example.librarymanagementsystem.Entity.StudentEntity;
import com.example.librarymanagementsystem.Respository.BookRepository;
import com.example.librarymanagementsystem.Respository.StudentRepository;
import com.example.librarymanagementsystem.Service.RelationService;
import com.example.librarymanagementsystem.Service.StudentService;
@RestController
public class StudentController {

    @Autowired 
    private StudentService ss;

     @Autowired
    private BookRepository br;

    @Autowired
    private StudentRepository sr;

    @Autowired
    private RelationService rs;
    
    @GetMapping("/allStudents")
    public ResponseEntity<List<StudentDto>> getStudents(@RequestParam String param) {
        List<StudentDto> s=this.ss.findAll();
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
    
   @PostMapping("/addStudent")
    public StudentEntity addStudent(@RequestBody StudentEntity param) {
        return this.ss.save(param);
    }
    
@PostMapping("/borrowbook/{stu_id}/{Book_id}")
public ResponseEntity<String> students_Book(@PathVariable Long stu_id, @PathVariable Long Book_id) {
    Optional<BookEntity> ob=this.br.findById(Book_id);
    Optional<StudentEntity> os=this.sr.findById(stu_id);
    
    if(ob.isPresent() && os.isPresent()){
        BookEntity b=ob.get();
        StudentEntity s=os.get();
        StudentBookRelation sbr= new StudentBookRelation();
        sbr.setBook(b);
        sbr.setStudent(s);
        sbr.setBorrowDate(LocalDate.now());

        LocalDate expectedReturnDate = LocalDate.now().plusDays(7);
        sbr.setExpected_ReturnDate(expectedReturnDate);
        rs.save(sbr);
        return ResponseEntity.ok("added succesfully");

    }else{
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student or book doesnot exists");}
}


//    @PutMapping("/updateStu/{Stu_Id}")
//    public void updateStudent(@RequestBody StudentEntity entity) {
       
//        return ;
//    }

}
