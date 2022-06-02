package com.aplha.test.controllers;

import com.aplha.test.services.GiphyService;
import com.aplha.test.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
//@RequestMapping("/api")
public class TestController {

//    @Autowired
//    RateService rateService;
//    @Autowired
//    GiphyService giphyService;
//
//    @GetMapping("/api")
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

        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "index";
    }
}
