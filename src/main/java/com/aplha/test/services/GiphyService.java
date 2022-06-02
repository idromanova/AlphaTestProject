package com.aplha.test.services;

import com.aplha.test.feighClients.GiphyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiphyService {
    @Autowired
    GiphyClient giphyClient;
    public String getUrl(boolean response)
    {
        return response? giphyClient.getGIF("rich").getUrl() : giphyClient.getGIF("broke").getUrl();
    }
}
