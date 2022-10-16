package com.fabits.crm.repository;

import com.fabits.crm.domain.MeetingInformation;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface MeetingRepository extends ReactiveCrudRepository<MeetingInformation, String> {

    Flux<MeetingInformation> findAllByMeetingTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    Flux<MeetingInformation> findAllByClientIdAndMeetingTimeAfter(String clientId, LocalDateTime when);

    Flux<MeetingInformation> findAllByEmplAndEmployeeIdAndMeetingTimeIsBetween(String employeeId, LocalDateTime start, LocalDateTime end);
}

