package com.aplha.test.controllers;

import com.aplha.test.services.GiphyService;
import com.aplha.test.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/api")
public class TestController {

    @Autowired
    RateService rateService;
    @Autowired
    GiphyService giphyService;

//    @GetMapping("/test")
//    //@RequestMapping("/api")
//   // @ResponseBody
//    public String test() {
//        try {
//            return "index.html";
//            //giphyService.getUrl(rateService.getRate()));
//
//        } catch (Exception e) {
//               return "";
//        }

        @GetMapping("/test")
        public String test(@RequestParam(name="src", required=false) String src, Model model) {
            model.addAttribute("src", giphyService.getUrl(rateService.getRate()));
            return "resultPage";
    }
}
