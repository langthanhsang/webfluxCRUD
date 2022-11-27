package com.techgeeknext.example.controller;

import com.techgeeknext.example.model.Employee;
import com.techgeeknext.example.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/create/emp")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmp(@RequestBody Employee employee) {
        employeeServiceImpl.createEmp(employee);
    }

    @GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Employee> findAll() {
        return employeeServiceImpl.findAllEmp();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Mono<Employee>> findEmpById(@PathVariable("id") Integer id) {
        Mono<Employee> employee = employeeServiceImpl.findByEmpId(id);
        return new ResponseEntity<Mono<Employee>>(employee, employee != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/emp")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> update(@RequestBody Employee employee) {
        return employeeServiceImpl.updateEmp(employee);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        employeeServiceImpl.deleteEmp(id).subscribe();
    }

}
