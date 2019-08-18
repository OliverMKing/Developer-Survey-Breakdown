package com.stack.data.api.v1.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResponseStatsDTO {

    private Integer responseCount;
    private Map<String, Integer> languages = new TreeMap<>();
    private Map<String, Integer> frameworks = new TreeMap<>();

    private Map<String, Integer> countries = new TreeMap<>();
    private Map<String, Integer> education = new TreeMap<>();
    private Map<String, Integer> devTypes = new TreeMap<>();
    private Map<String, Integer> yearsCoding = new TreeMap<>();
    private Map<String, Integer> jobSatisfactions = new TreeMap<>();

    public ResponseStatsDTO() {
    }

    public ResponseStatsDTO(List<ResponseDTO> responseDTOS) {
        this.responseCount = responseDTOS.size();
        setLanguagesAndFrameworks(responseDTOS);
    }

    private void setLanguagesAndFrameworks(List<ResponseDTO> responseDTOS) {
        fillLanguageAndFrameworksAndPropertiesMaps(responseDTOS,
                languages,
                frameworks,
                countries,
                education,
                devTypes,
                yearsCoding,
                jobSatisfactions
        );
    }

    static void fillLanguageAndFrameworksMaps(List<ResponseDTO> responseDTOS,
                                              Map<String, Integer> languages,
                                              Map<String, Integer> frameworks) {
        for (ResponseDTO response : responseDTOS) {
            for (String language : response.getLanguages()) {
                languages.put(language, languages.getOrDefault(language, 0) + 1);
            }
            for (String framework : response.getFrameworks()) {
                frameworks.put(framework, frameworks.getOrDefault(framework, 0) + 1);
            }
        }
    }

    static void fillLanguageAndFrameworksAndPropertiesMaps(List<ResponseDTO> responseDTOS,
                                                           Map<String, Integer> languages,
                                                           Map<String, Integer> frameworks,
                                                           Map<String, Integer> countries,
                                                           Map<String, Integer> education,
                                                           Map<String, Integer> devTypes,
                                                           Map<String, Integer> yearsCoding,
                                                           Map<String, Integer> jobSatisfactions
                                                           ) {
        for (ResponseDTO response : responseDTOS) {
            for (String language : response.getLanguages()) {
                languages.put(language, languages.getOrDefault(language, 0) + 1);
            }
            for (String framework : response.getFrameworks()) {
                frameworks.put(framework, frameworks.getOrDefault(framework, 0) + 1);
            }
            if (response.getCountry() != null)
                countries.put(response.getCountry(), countries.getOrDefault(response.getCountry(), 0) + 1);
            if (response.getFormalEducation() != null)
                education.put(response.getFormalEducation(), education.getOrDefault(response.getFormalEducation(), 0) + 1);
            if (response.getDevType() != null) {
                String[] types = response.getDevType().split(";");
                for (String type : types) {
                    devTypes.put(type, devTypes.getOrDefault(type, 0) + 1);
                }
            }
            if (response.getYearsCoding() != null)
                yearsCoding.put(response.getYearsCoding(), yearsCoding.getOrDefault(response.getYearsCoding(), 0) + 1);
            if (response.getJobSatisfaction() != null)
                jobSatisfactions.put(response.getJobSatisfaction(), jobSatisfactions.getOrDefault(response.getJobSatisfaction(), 0) + 1);
        }
    }

    public Map<String, Integer> getYearsCoding() {
        return yearsCoding;
    }

    public void setYearsCoding(Map<String, Integer> yearsCoding) {
        this.yearsCoding = yearsCoding;
    }

    public Map<String, Integer> getJobSatisfactions() {
        return jobSatisfactions;
    }

    public void setJobSatisfactions(Map<String, Integer> jobSatisfactions) {
        this.jobSatisfactions = jobSatisfactions;
    }

    public Map<String, Integer> getEducation() {
        return education;
    }

    public void setEducation(Map<String, Integer> education) {
        this.education = education;
    }

    public Map<String, Integer> getDevTypes() {
        return devTypes;
    }

    public void setDevTypes(Map<String, Integer> devTypes) {
        this.devTypes = devTypes;
    }

    public Map<String, Integer> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, Integer> countries) {
        this.countries = countries;
    }

    public Integer getResponseCount() {
        return responseCount;
    }

    public void setResponseCount(Integer responseCount) {
        this.responseCount = responseCount;
    }

    public Map<String, Integer> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, Integer> languages) {
        this.languages = languages;
    }

    public Map<String, Integer> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(Map<String, Integer> frameworks) {
        this.frameworks = frameworks;
    }
}
