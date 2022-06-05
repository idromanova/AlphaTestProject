package com.aplha.test.services;

import com.aplha.test.feighClients.RateClient;
import com.aplha.test.models.RateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class RateService {

        @Autowired
        RateClient rateFeignClient;

//        @Value("${client.rate.symbol}")
//        private String rateName;

        public Boolean getRate(String symbol){
            double thisDay = rateFeignClient
                    .getInfoByThisDay(symbol)
                    .getRates().get(symbol);

            LocalDate today = LocalDate.now();
            LocalDate yesterday = today.minusDays(1);
            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
            double previousDay = rateFeignClient.getInfoByPreviousDay(yesterday.format(formatter), symbol).getRates().get(symbol);

            return thisDay > previousDay;

    }
}
