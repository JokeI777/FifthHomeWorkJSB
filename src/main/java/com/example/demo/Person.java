package com.example.demo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Person {
    @Birthday
    LocalDate birthday;
    @NotBlank
    @Length(max = 125)
    String name;
    @Length(max = 150)
    String sname;
    @NotNull
    Sex sex;

    public Person(LocalDate birthday, String name, String sname, Sex sex){
        this.birthday = birthday;
        this.name = name;
        this.sname = sname;
        this.sex = sex;
    }
}

enum Sex {
    MALE,
    FEMALE
}

