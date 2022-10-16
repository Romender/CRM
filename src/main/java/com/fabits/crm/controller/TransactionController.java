package com.fabits.crm.controller;

import com.fabits.crm.domain.TransactionInfo;
import com.fabits.crm.service.TransactionInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionInfoService service;

    @GetMapping
    public Flux<TransactionInfo> findAllTransactionByClientId(@RequestParam("clientId") String clientId) {
        return service.findAllForClientId(clientId);
    }
}
