package com.sscodes.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {

    @Id
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;


    @Getter
    @Setter
    @DBRef
    private Department department;

}
