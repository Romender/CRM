package com.fabits.crm.repository;

import com.fabits.crm.domain.TransactionInfo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionInfoRepository extends ReactiveCrudRepository<TransactionInfo, String> {
}
