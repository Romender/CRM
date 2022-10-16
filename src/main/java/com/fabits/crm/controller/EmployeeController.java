package com.fabits.crm.controller;

import com.fabits.crm.domain.Employee;
import com.fabits.crm.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/all")
    public Flux<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Employee> save(@RequestBody Employee employee) {
        return service.saveOrUpdate(employee);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return service.deleteById(id);
    }
}
