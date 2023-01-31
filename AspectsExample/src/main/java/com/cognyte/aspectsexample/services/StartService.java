package com.cognyte.aspectsexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartService {
    private final CognyteMainService mainService;

    @Autowired
    public StartService(CognyteMainService mainService) {
        this.mainService = mainService;
    }

    public void start() {
        System.out.println("starting...");
        mainService.work();
    }
}
