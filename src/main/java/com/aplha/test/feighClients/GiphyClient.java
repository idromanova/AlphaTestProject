package com.aplha.test.feighClients;

import com.aplha.test.models.GiphyFullModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphyFeignClient", url = "${client.giphy.baseUrl}")
public interface GiphyClient {

    @GetMapping("random?api_key=${client.giphy.app_key}")
    GiphyFullModel getGIF(@RequestParam String tag);

}