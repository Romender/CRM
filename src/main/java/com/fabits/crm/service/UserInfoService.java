package com.fabits.crm.service;

import com.fabits.crm.repository.UserInfoRepository;
import com.fabits.crm.security.domain.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserInfoService {
    private final UserInfoRepository repository;

    public Mono<UserInfo> createUser(UserInfo userInfo) {
        return repository.save(userInfo);
    }

    public Flux<UserInfo> getAll() {
        return repository.findAll();
    }

    public Mono<UserInfo> findByUserName(String userName) {
        return repository.findById(userName);
    }
}
