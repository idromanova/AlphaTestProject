package com.aplha.test.services;

import com.aplha.test.feighClients.RateClient;
import com.aplha.test.models.RateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Service
public class RateService {

        @Autowired
        RateClient rateFeignClient;

        @Value("${client.rate.symbol}")
        private String rateName;

        public Boolean getRate(){
            double thisDay = rateFeignClient
                    .getInfoByThisDay()
                    .getRates(rateName);

            LocalDate today = LocalDate.now();
            LocalDate yesterday = today.minusDays(1);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            double previousDay = rateFeignClient.getInfoByPreviousDay(formatter.format(yesterday)).getRates(rateName);

            return thisDay>previousDay?true:false;

    }
}
