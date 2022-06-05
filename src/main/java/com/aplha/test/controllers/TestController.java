package com.aplha.test.controllers;

import com.aplha.test.services.GiphyService;
import com.aplha.test.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/api/romanova/alpha")
public class TestController {

    @Autowired
    RateService rateService;
    @Autowired
    GiphyService giphyService;

    @GetMapping("/rates/{symbol}")
    public String getResult(@PathVariable String symbol, Model model) {
        String defaultResult = "resultPage";
        try {
            model.addAttribute("src", giphyService.getUrl(rateService.getRate(symbol)));
        }
        catch (Exception e)
        {
            model.addAttribute("src", e.getMessage());
            defaultResult="index";
        }
        return defaultResult;
    }
}
