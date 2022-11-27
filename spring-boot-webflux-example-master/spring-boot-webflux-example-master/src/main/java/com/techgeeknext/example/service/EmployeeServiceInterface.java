package com.techgeeknext.example.service;

import com.techgeeknext.example.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface EmployeeServiceInterface
{
    void createEmp(Employee e);
     
    Mono<Employee> findByEmpId(Integer id);
 
    Flux<Employee> findAllEmp();
 
    Mono<Employee> updateEmp(Employee e);
 
    Mono<Void> deleteEmp(Integer id);
}