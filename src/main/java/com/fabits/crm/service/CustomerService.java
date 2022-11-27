package com.fabits.crm.service;

import com.fabits.crm.domain.Customer;
import com.fabits.crm.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.Objects.requireNonNull;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository repository;

    public Mono<Customer> saveOrUpdate(Customer customer) {
        return repository.existsById(requireNonNull(customer.getClientId(), "Customer clientId cannot be null"))
                .log()
                .flatMap(x -> {
                    log.info("Customer doesn't exists with id "+customer.getClientId() +" --> "+ x);
                    customer.setNew(!x);
                   return Mono.just(customer);
                }).doOnNext(repository::save);
    }

    public void saveCustomer(Customer customer) {
          repository.existsById(requireNonNull(customer.getClientId(), "Customer clientId cannot be null"))
                .log()
                .flatMap(x -> {
                    log.info("Customer doesn't exists with id "+customer.getClientId() +" --> "+ x);
                    customer.setNew(!x);
                    return repository.save(customer);
                }).block();
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
