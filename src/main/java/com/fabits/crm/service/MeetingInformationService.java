package com.fabits.crm.service;

import com.fabits.crm.domain.MeetingInformation;
import com.fabits.crm.repository.MeetingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MeetingInformationService {

    private final MeetingRepository repository;

    public Mono<MeetingInformation> saveOrUpdate(MeetingInformation meetingInformation) {
        if (Objects.isNull(meetingInformation.getId())) {
            meetingInformation.setId(UUID.randomUUID().toString());
            meetingInformation.setNew(true);
        }
        return repository.save(meetingInformation);
    }

    public Mono<Void> deleteMeeting(String id) {
        return repository.deleteById(id);
    }

    public Flux<MeetingInformation> findAll() {
        return repository.findAll();
    }

    public Flux<MeetingInformation> findByBetween(LocalDateTime startDate, LocalDateTime endDate) {
        if (Objects.isNull(endDate)) {
            endDate = LocalDateTime.MAX;
        }
        return repository.findAllByMeetingTimeBetween(startDate, endDate);
    }

    public Flux<MeetingInformation> findAllClientId(String clientId, LocalDateTime when) {
        return repository.findAllByClientIdAndMeetingTimeAfter(clientId,
                Objects.isNull(when) ? LocalDate.now().atStartOfDay() : when);
    }

    public Flux<MeetingInformation> findAllMeetingOfEmployee(String employeeId, LocalDateTime when) {
        if (Objects.isNull(when)){
            when = LocalDate.now().atStartOfDay();
        }
        return repository.findAllByEmplAndEmployeeIdAndMeetingTimeIsBetween(employeeId, when, when.plusDays(1));
    }
}
