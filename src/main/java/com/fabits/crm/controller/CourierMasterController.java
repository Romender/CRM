package com.fabits.crm.controller;

import com.fabits.crm.domain.CourierMaster;
import com.fabits.crm.repository.CourierMasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/courier")
@AllArgsConstructor
public class CourierMasterController {

    private final CourierMasterRepository repository;

    @GetMapping("/{id}")
    public Mono<CourierMaster> getCourierById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<CourierMaster> saveOrUpdateCourier(@RequestBody CourierMaster courierMaster) {
         return repository.save(courierMaster);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCourier(@PathVariable("id") String id) {
       return repository.deleteById(id);
    }

    @GetMapping("/all")
    public Flux<CourierMaster> getAll() {
        return repository.findAll();
    }

}
