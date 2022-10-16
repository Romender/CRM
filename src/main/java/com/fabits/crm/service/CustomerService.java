package com.fabits.crm.service;

import com.fabits.crm.domain.Customer;
import com.fabits.crm.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Mono<Customer> saveOrUpdate(Customer customer) {
        return repository.existsById(Objects.requireNonNull(customer.getClientId(), "Customer clientId cannot be null"))
                .flatMap(x -> {
                    customer.setNew(!x);
                    return repository.save(customer);
                });
    }

    public Mono<Customer> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Void> deleteCustomer(String id) {
        return repository.deleteById(id);
    }

    public Flux<Customer> findAll() {
        return repository.findAll();
    }
}
