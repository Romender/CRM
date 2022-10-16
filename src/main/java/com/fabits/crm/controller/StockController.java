package com.fabits.crm.controller;

import com.fabits.crm.domain.StockInfo;
import com.fabits.crm.service.StockInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {

    private final StockInfoService service;

    @GetMapping("/{id}")
    public Mono<StockInfo> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public Flux<StockInfo> findAll() {
        return service.findAll();
    }
}
