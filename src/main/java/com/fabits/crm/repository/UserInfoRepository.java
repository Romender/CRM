package com.fabits.crm.repository;

import com.fabits.crm.security.domain.UserInfo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserInfoRepository extends ReactiveCrudRepository<UserInfo, String> {
}
