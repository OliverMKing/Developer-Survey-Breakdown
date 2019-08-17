package com.stack.data.api.v1.models;

import java.util.Set;

public class ResponseDTO {

    private Long id;
    private String country;
    private String formalEducation;
    private String devType;
    private Integer yearsCoding;
    private String jobSatisfaction;
    private Double salary;
    private Set<String> languages;
    private Set<String> frameworks;

    public ResponseDTO() {
    }

    public ResponseDTO(Long id, String country, String formalEducation,
                       String devType, Integer yearsCoding,
                       String jobSatisfaction, Double salary,
                       Set<String> languages, Set<String> frameworks) {
        this.id = id;
        this.country = country;
        this.formalEducation = formalEducation;
        this.devType = devType;
        this.yearsCoding = yearsCoding;
        this.jobSatisfaction = jobSatisfaction;
        this.salary = salary;
        this.languages = languages;
        this.frameworks = frameworks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFormalEducation() {
        return formalEducation;
    }

    public void setFormalEducation(String formalEducation) {
        this.formalEducation = formalEducation;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public Integer getYearsCoding() {
        return yearsCoding;
    }

    public void setYearsCoding(Integer yearsCoding) {
        this.yearsCoding = yearsCoding;
    }

    public String getJobSatisfaction() {
        return jobSatisfaction;
    }

    public void setJobSatisfaction(String jobSatisfaction) {
        this.jobSatisfaction = jobSatisfaction;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    public Set<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(Set<String> frameworks) {
        this.frameworks = frameworks;
    }
}
