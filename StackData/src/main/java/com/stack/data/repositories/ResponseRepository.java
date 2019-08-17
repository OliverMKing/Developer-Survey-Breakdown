package com.stack.data.repositories;

import com.stack.data.domain.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {

    List<Response> findAllByCountry(String country);
    List<Response> findAllByFormalEducation(String formalEducation);
    List<Response> findAllByDevType(String devType);
    List<Response> findAllByYearsCoding(Integer yearsCoding);
    List<Response> findAllByJobSatisfaction(String jobSatisfaction);
    List<Response> findAllBySalary(String salary);
}
