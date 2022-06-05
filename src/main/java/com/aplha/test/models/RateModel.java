package com.aplha.test.models;

import java.util.HashMap;

public class RateModel {
    private HashMap<String, Double> rates;

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }
    public HashMap<String, Double> getRates() {
        return rates;
    }
}
