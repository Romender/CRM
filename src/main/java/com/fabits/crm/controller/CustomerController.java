package com.fabits.crm.controller;

import com.fabits.crm.domain.Customer;
import com.fabits.crm.service.CustomerService;
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
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public Mono<Customer> saveOrUpdate(@RequestBody Customer customer) {
        return service.saveOrUpdate(customer);
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable String id) {
        return service.deleteCustomer(id);
    }

    @GetMapping("/all")
    public Flux<Customer> findAll() {
        return service.findAll();
    }
}
