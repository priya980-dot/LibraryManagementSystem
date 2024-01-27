package com.example.librarymanagementsystem.Dto;

import org.codehaus.jackson.annotate.JsonProperty;

import lombok.*;

@Getter
@Setter
public class StudentDto {
    @JsonProperty("first_name")
    String first_name;

    @JsonProperty("last_name")
    String last_name;

    @JsonProperty("gender")
    String gender;

    @JsonProperty("mobile")
    Integer mobile;

    @JsonProperty("DOB")
    Integer DOB;

    @JsonProperty("Address")
    String Address;

    @JsonProperty("borrowOrnot")
    Boolean borrowOrnot;
}
