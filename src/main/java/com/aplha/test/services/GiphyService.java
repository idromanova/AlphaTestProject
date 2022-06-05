package com.aplha.test.services;

import com.aplha.test.feighClients.GiphyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GiphyService {
    @Autowired
    GiphyClient giphyClient;

    @Value("${client.rate.baseUrl}")
    String url;

    public String getUrl(boolean response) throws Exception { try {
        return response ? giphyClient.getGIF("rich")
                .getData()
                .getImages()
                .getOriginal()
                .getUrl()
                : giphyClient.getGIF("broke")
                .getData()
                .getImages()
                .getOriginal()
                .getUrl();
        }
        catch (Exception e)
        {
            throw new Exception("Ошибка получения данных с сервера " + url);
        }
    }
}
