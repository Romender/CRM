package com.fabits.crm.repository;

import com.fabits.crm.security.domain.UserInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;

@DataR2dbcTest
public class TestUseAuthenticationRepository {

    @Autowired
    private UserInfoRepository testRepository;

    private void insertUser(){
        UserInfo userInfo = UserInfo.builder()
                .accountNonExpired(false)
                .accountNonLocked(false)
                .credentialsNonExpired(false)
                .enabled(true)
                .username("Test-User")
                .password("HelloWorld")
                .build();
        testRepository.save(userInfo);
    }

    @Test
    public void retriveUser() {
        insertUser();
        UserInfo user = testRepository.findAll().blockFirst();
        Assertions.assertThat(user.getUsername()).isEqualTo("Test-User");
    }
}
