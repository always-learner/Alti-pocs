package com.sscodes.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@EqualsAndHashCode
@ToString
public class Department {

    @Id
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @DBRef
    @Getter
    @Setter
    private List<Employee> employees;
}
