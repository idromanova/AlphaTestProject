package com.aplha.test.feighClients;

import com.aplha.test.models.RateModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rateFeignClient", url = "${client.post.baseUrl}")
public interface RateClient {
    @GetMapping("latest.json?app_id=${client.rate.app_key}&symbols=${client.rate.symbol}")
    public RateModel getInfoByThisDay();

    @GetMapping("historical/${date}.json?app_idпш=55ce99a0135b42cab9d2f887a6dc0e9e&symbols=AED")
    public RateModel getInfoByPreviousDay(@RequestParam String date);



}
