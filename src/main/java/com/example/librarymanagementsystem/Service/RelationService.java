package com.example.librarymanagementsystem.Service;


import org.springframework.stereotype.Service;

import com.example.librarymanagementsystem.Entity.StudentBookRelation;
import com.example.librarymanagementsystem.Respository.RelationRepository;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class RelationService {
    @Autowired
    private RelationRepository rr;

       public StudentBookRelation save(StudentBookRelation sturb) {
        return this.rr.save(sturb);
    }

    
}
