package com.example.librarymanagementsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagementsystem.Dto.DepartmentDto;
import com.example.librarymanagementsystem.Dto.DepartmentNameDto;
import com.example.librarymanagementsystem.Entity.Book_Department;
import com.example.librarymanagementsystem.Service.DepartmentService;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService ds;

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentNameDto>> getAuthors() {
        List<DepartmentNameDto> a = this.ds.allDepartments();

        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/department_books/{Id}")
    public ResponseEntity<DepartmentDto> getAuthorById(@PathVariable Long Id) {

        return this.ds.byid(Id);
    }

    @PostMapping("/addDep")
    public ResponseEntity<String> addDep(@RequestBody Book_Department param) {

        // Book_Department b_d=ds.mapDtoToEntity(param);
        this.ds.save(param);
        return ResponseEntity.ok("Department added Successfully");

    }

    // @PutMapping("/updateDep/{dep_id}")
    // public void updateDep(@RequestBody Book_Department entity) {

    // return ;
    // }

}
