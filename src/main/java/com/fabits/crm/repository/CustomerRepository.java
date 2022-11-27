package com.fabits.crm.repository;

import com.fabits.crm.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

    Flux<Customer> findCustomersByBankName(String bankName);

}
