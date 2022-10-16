package com.fabits.crm.controller;

import com.fabits.crm.domain.NonRegisteredClient;
import com.fabits.crm.service.NonRegisteredClientService;
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
@RequestMapping("/non-client")
@AllArgsConstructor
public class NonRegisteredClientController {

    private final NonRegisteredClientService service;

    @GetMapping("/all")
    public Flux<NonRegisteredClient> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<NonRegisteredClient> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<NonRegisteredClient> save(@RequestBody NonRegisteredClient client) {
        return service.saveOrUpdate(client);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return service.deleteById(id);
    }

}
