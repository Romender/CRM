package com.fabits.crm.service;

import com.fabits.crm.domain.Employee;
import com.fabits.crm.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Mono<Employee> saveOrUpdate(Employee employee) {
        return repository.existsById(Objects.requireNonNull(employee.getId(), "Employee Id cannot be auto-generated."))
                .flatMap(x -> {
                    employee.setNew(!x);
                    return Mono.just(employee);
                }).doOnNext(repository::save);
    }

    public Flux<Employee> findAll() {
        return repository.findAll();
    }

    public Mono<Employee> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

}
