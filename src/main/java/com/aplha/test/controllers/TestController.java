package com.aplha.test.controllers;

import com.aplha.test.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    RateService rateService;

    @GetMapping("/test")
        public String test() {
            return rateService.getRate() ? "true": "false";
        }
}
