package com.stack.data.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Response extends BaseEntity {

    private String country;
    private String formalEducation;
    @Column(length = 1000)
    private String devType;
    private String yearsCoding;
    private String jobSatisfaction;
    private Double salary;

    @ElementCollection
    private Set<String> languages;

    @ElementCollection
    private Set<String> frameworks;

    public Response() {
    }

    public Response(String country, String formalEducation,
                    String devType, String yearsCoding,
                    String jobSatisfaction, Double salary,
                    Set<String> languages, Set<String> frameworks) {
        this.country = country;
        this.formalEducation = formalEducation;
        this.devType = devType;
        this.yearsCoding = yearsCoding;
        this.jobSatisfaction = jobSatisfaction;
        this.salary = salary;
        this.languages = languages;
        this.frameworks = frameworks;
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

    public String getYearsCoding() {
        return yearsCoding;
    }

    public void setYearsCoding(String yearsCoding) {
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
