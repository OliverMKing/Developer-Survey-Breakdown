package com.stack.data.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Response extends BaseEntity {

    private String country;
    private String formalEducation;
    private String devType;
    private Integer yearsCoding;
    private String jobSatisfaction;
    private Double salary;

    @ElementCollection
    private Set<String> languages;

    @ElementCollection
    private Set<String> frameworks;
}
