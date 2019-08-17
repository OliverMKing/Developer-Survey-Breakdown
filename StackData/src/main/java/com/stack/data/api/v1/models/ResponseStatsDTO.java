package com.stack.data.api.v1.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseStatsDTO {

    Integer responseCount;
    Map<String, Integer> languages = new HashMap();
    Map<String, Integer> frameworks = new HashMap();

    public ResponseStatsDTO() {
    }

    public ResponseStatsDTO(List<ResponseDTO> responseDTOS) {
        this.responseCount = responseDTOS.size();
        setLanguagesAndFrameworks(responseDTOS);
    }

    private void setLanguagesAndFrameworks(List<ResponseDTO> responseDTOS) {
        for (ResponseDTO response : responseDTOS) {
            for (String language : response.getLanguages()) {
                languages.put(language, languages.getOrDefault(language, 0) + 1);
            }
            for (String framework : response.getFrameworks()) {
                frameworks.put(framework, frameworks.getOrDefault(framework, 0) + 1);
            }
        }
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
