package com.fabits.crm.repository;

import com.fabits.crm.domain.CourierMaster;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CourierMasterRepository extends ReactiveCrudRepository<CourierMaster, String> {

    Mono<CourierMaster> findByCompanyName(String companyName);
}
