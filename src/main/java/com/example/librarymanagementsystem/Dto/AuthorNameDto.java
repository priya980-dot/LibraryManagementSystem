package com.example.librarymanagementsystem.Dto;


import org.codehaus.jackson.annotate.JsonProperty;

import lombok.*;

@Getter
@Setter
public class AuthorNameDto {

    @JsonProperty("name")
    private String authorName;
}
    

