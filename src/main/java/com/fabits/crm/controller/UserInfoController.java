package com.fabits.crm.controller;

import com.fabits.crm.security.domain.UserInfo;
import com.fabits.crm.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@AllArgsConstructor
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping(path ="/user/all")
    public Flux<UserInfo> fetchAll() {
        return userInfoService.getAll();
    }

    @PostMapping(path = "/user")
    public Mono<UserInfo> createUser(@RequestBody UserInfo userInfo) {
        return userInfoService.createUser(userInfo);
    }

    @GetMapping(path = "/user")
    public Mono<UserInfo> fetchByUserName(@RequestParam String userName) {
        return userInfoService.findByUserName(userName);
    }
}
