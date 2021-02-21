package com.account.account.controller;

import com.account.account.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
public class AccountController {

    private Map<String, Account> accountMap = new HashMap<>();
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/account/create")
    public ResponseEntity<Object> createAccount(@RequestBody Account account) {
        account.setType("ACCOUNT_CREATED");
        account.setLastUpdateTimeStamp(LocalDateTime.now());

        accountMap.put(account.getAccountNumber(), account);
        for (Map.Entry<String, Account> entry : accountMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }

        final String uri = "http://localhost:8085/events";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(uri, account, Account.class);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
