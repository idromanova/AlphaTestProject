package com.aplha.test.models;

import java.util.HashMap;

public class RateModel {
    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private HashMap<String, Double> rates;

    public HashMap<String, Double> getRates() {
        return rates;
    }
}
