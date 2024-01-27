package com.example.librarymanagementsystem.Service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.librarymanagementsystem.Dto.StudentDto;
import com.example.librarymanagementsystem.Entity.StudentEntity;
import com.example.librarymanagementsystem.Respository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class StudentService {
    @Autowired
    private StudentRepository sr;

    @Autowired
    private ModelMapper modelMapper;

    public List<StudentDto> findAll() {
        List<StudentEntity> bb = this.sr.findAll();
        List<StudentDto> bdt = new ArrayList<>();
        for (StudentEntity b : bb) {
            StudentDto bd = modelMapper.map(b, StudentDto.class);
            bdt.add(bd);

        }
        return bdt;
    }

    public StudentEntity save(StudentEntity stu) {
        return this.sr.save(stu);
    }

}
