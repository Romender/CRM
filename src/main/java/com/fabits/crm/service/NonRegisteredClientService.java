package com.fabits.crm.service;

import com.fabits.crm.domain.NonRegisteredClient;
import com.fabits.crm.repository.NonRegisteredRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class NonRegisteredClientService {

    private final NonRegisteredRepository repository;

    public Mono<NonRegisteredClient> saveOrUpdate(NonRegisteredClient client) {
        return repository.existsById(Objects.requireNonNull(client.getId(), "Client Id cannot be null"))
                .flatMap(x -> {
                    client.setNew(!x);
                    return repository.save(client);
                });
    }

    public Flux<NonRegisteredClient> findAll() {
        return repository.findAll();
    }

    public Mono<NonRegisteredClient> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
