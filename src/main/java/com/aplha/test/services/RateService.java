package com.aplha.test.services;

import com.aplha.test.feighClients.RateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class RateService {

        @Autowired
        RateClient rateFeignClient;

        public Boolean getRate(String symbol){
            symbol = symbol.toUpperCase(Locale.ROOT);

            double thisDay = rateFeignClient
                    .getInfoByThisDay(symbol)
                    .getRates()
                    .get(symbol);

            LocalDate today = LocalDate.now();
            LocalDate yesterday = today.minusDays(1);
            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

            double previousDay = rateFeignClient
                    .getInfoByPreviousDay(yesterday.format(formatter), symbol)
                    .getRates()
                    .get(symbol);

            return thisDay > previousDay;
    }
}
