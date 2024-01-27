package com.example.librarymanagementsystem.Dto;

import java.util.*;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.*;

@Getter
@Setter
public class DepartmentDto {

    @JsonProperty("department")
    private String dep_name;

     @JsonProperty("books")
    Set<String> books;

    
}
