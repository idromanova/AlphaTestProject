package com.aplha.test.feighClients;

import com.aplha.test.models.RateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rateFeignClient", url = "${client.rate.baseUrl}")
public interface RateClient {

    @GetMapping("latest.json?app_id=${client.rate.app_key}&base=${client.rate.base}&symbols={symbol}")
    RateModel getInfoByThisDay(String symbol);

    @GetMapping("historical/{date}.json?app_id=${client.rate.app_key}&base=${client.rate.base}&symbols={symbol}")
    RateModel getInfoByPreviousDay(@RequestParam String date, String symbol);

}
