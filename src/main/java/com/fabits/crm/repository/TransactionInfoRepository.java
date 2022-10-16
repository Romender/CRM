package com.fabits.crm.repository;

import com.fabits.crm.domain.TransactionInfo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TransactionInfoRepository extends ReactiveCrudRepository<TransactionInfo, String> {

    Flux<TransactionInfo> findAllByClientId(String clientId);
}
