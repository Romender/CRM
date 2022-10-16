package com.fabits.crm.service;

import com.fabits.crm.domain.TransactionInfo;
import com.fabits.crm.repository.TransactionInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionInfoService {

    private final TransactionInfoRepository repository;

    public Mono<TransactionInfo> saveOrUpdate(TransactionInfo transactionInfo) {
        if (Objects.isNull(transactionInfo.getId())) {
            transactionInfo.setNew(true);
            transactionInfo.setId(UUID.randomUUID().toString());
        }
        return repository.save(transactionInfo);
    }

    public Flux<TransactionInfo> findAllForClientId(String clientId) {
        return repository.findAllByClientId(clientId);
    }

}
