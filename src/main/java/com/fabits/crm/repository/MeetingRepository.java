package com.fabits.crm.repository;

import com.fabits.crm.domain.MeetingInformation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MeetingRepository extends ReactiveCrudRepository<MeetingInformation, String> {
}
