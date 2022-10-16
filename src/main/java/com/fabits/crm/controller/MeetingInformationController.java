package com.fabits.crm.controller;

import com.fabits.crm.domain.MeetingInformation;
import com.fabits.crm.service.MeetingInformationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController()
@RequestMapping("/meeting")
@AllArgsConstructor
public class MeetingInformationController {

    private final MeetingInformationService service;

    @PostMapping("/search")
    public Flux<MeetingInformation> fetchLatestMeeting(@RequestParam("startDate") String startDate,
                                                       @RequestParam("endDate")String endDate) {
        return service.findByBetween(LocalDateTime.parse(startDate, DateTimeFormatter.ISO_DATE_TIME),
                LocalDateTime.parse(endDate,DateTimeFormatter.ISO_DATE_TIME));
    }

    @PostMapping
    public Mono<MeetingInformation> saveMeetingInfo(@RequestBody MeetingInformation meetingInformation) {
        return service.saveOrUpdate(meetingInformation);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMeetingById(@PathVariable("id") String id) {
        return service.deleteMeeting(id);
    }

    @GetMapping("/all")
    public Flux<MeetingInformation> findAll(){
        return service.findAll();
    }

}
