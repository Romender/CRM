package com.fabits.crm.service;

import com.fabits.crm.domain.StockInfo;
import com.fabits.crm.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@AllArgsConstructor
public class StockInfoService {

    private final StockRepository repository;

    public Mono<StockInfo> saveOrUpdate(StockInfo stockInfo) {
        return repository.existsById(Objects.requireNonNull(stockInfo.getIscNumber()))
                .flatMap(x -> {
                    stockInfo.setNew(!x);
                    return repository.save(stockInfo);
                });
    }

    public Mono<StockInfo> findById(String id) {
        return repository.findById(id);
    }

    public Flux<StockInfo> findAll() {
        return repository.findAll();
    }

}
