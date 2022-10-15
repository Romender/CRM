package com.fabits.crm.repository;

import com.fabits.crm.domain.CourierMaster;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CourierMasterRepository extends ReactiveCrudRepository<CourierMaster, String> {
}
