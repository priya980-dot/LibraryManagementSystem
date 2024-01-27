package com.example.librarymanagementsystem.Dto;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.*;

@Getter
@Setter
public class DepartmentNameDto {
    @JsonProperty("department")
    private String dep_name;




}
