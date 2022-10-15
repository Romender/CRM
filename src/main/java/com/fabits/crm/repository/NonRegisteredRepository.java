package com.fabits.crm.repository;

import com.fabits.crm.domain.NonRegisteredClient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NonRegisteredRepository extends ReactiveCrudRepository<NonRegisteredClient, String> {
}
