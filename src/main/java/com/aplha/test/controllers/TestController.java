package com.aplha.test.controllers;

import com.aplha.test.services.GiphyService;
import com.aplha.test.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TestController {

    @Autowired
    RateService rateService;

    @Autowired
    GiphyService giphyService;

    @GetMapping("/test")
        public String test() {
            return "GIF URL - " + giphyService.getUrl(rateService.getRate()) ;
        }
}
