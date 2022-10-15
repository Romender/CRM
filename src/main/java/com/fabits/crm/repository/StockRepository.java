package com.fabits.crm.repository;

import com.fabits.crm.domain.StockInfo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StockRepository extends ReactiveCrudRepository<StockInfo, String> {
}
