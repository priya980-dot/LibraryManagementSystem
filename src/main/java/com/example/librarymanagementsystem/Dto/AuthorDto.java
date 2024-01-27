package com.example.librarymanagementsystem.Dto;

import java.util.*;



import org.codehaus.jackson.annotate.JsonProperty;

import lombok.*;

@Getter
@Setter
public class AuthorDto {
    @JsonProperty("name")
    String Author_name;

    @JsonProperty("books")
    Set<String> books;

}
