package com.example.librarymanagementsystem.Service;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.librarymanagementsystem.Dto.DepartmentDto;
import com.example.librarymanagementsystem.Dto.DepartmentNameDto;
import com.example.librarymanagementsystem.Entity.BookEntity;
import com.example.librarymanagementsystem.Entity.Book_Department;
import com.example.librarymanagementsystem.Respository.DepartmentRepository;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository dr;
    //  @Autowired
    // private ModelMapper modelMapper;

    
    public List<DepartmentNameDto> allDepartments(){
        List<Book_Department> aa= this.dr.findAll();
        List<DepartmentNameDto> btl=new ArrayList<>();
		for(Book_Department b:aa) {
            DepartmentNameDto ad=new DepartmentNameDto();
			ad.setDep_name(b.getDep_name());
			btl.add(ad);
        }
            return (btl);
    }


    public ResponseEntity<DepartmentDto> byid(Long i){
        Optional<Book_Department> aa= this.dr.findById(i);
        if(!aa.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
        DepartmentDto ad=new DepartmentDto();
        ad.setDep_name(aa.get().getDep_name());
        
        Set<String> bookNames = aa.get().getBooks().stream()
                .map(BookEntity::getBook_name)
                .collect(Collectors.toSet());

        ad.setBooks(bookNames);


        System.err.println(aa.get().getBooks());
          return ResponseEntity.ok(ad);}
        
    }

public Book_Department mapDtoToEntity(DepartmentNameDto dnd){

    Book_Department bd=new Book_Department();
    bd.setDep_name(dnd.getDep_name());
    return bd;
}



    public Book_Department save(Book_Department bd){
        System.out.println("added department is : "+ bd.getDep_name());
        return this.dr.save(bd);
    }
}
