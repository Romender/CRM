package com.fabits.crm.service;

import com.fabits.crm.domain.CourierMaster;
import com.fabits.crm.repository.CourierMasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CourierService {

    private CourierMasterRepository repository;

    public Mono<CourierMaster> saveOrUpdate(CourierMaster courierMaster) {
        if (Objects.isNull(courierMaster.getId())){
            courierMaster.setNew(true);
            courierMaster.setId(UUID.randomUUID().toString());
        }
        return repository.save(courierMaster);
    }

    public Mono<CourierMaster> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    public Mono<CourierMaster> findByName(String name) {
        return repository.findByCompanyName(name);
    }

    public Flux<CourierMaster> findAll() {
        return repository.findAll();
    }
}
