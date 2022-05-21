package com.bhaskor.CryptoPriceTracker.Response;

import java.util.HashMap;
import java.util.Map;

public class BitcoinPrice {
    Map<String, Long> bitcoin = new HashMap<>();

    public BitcoinPrice() {
    }

    public BitcoinPrice(Map<String,Long> bitcoin) {
        this.bitcoin = bitcoin;
    }

    public Map<String,Long> getBitcoin() {
        return this.bitcoin;
    }

    public void setBitcoin(Map<String,Long> bitcoin) {
        this.bitcoin = bitcoin;
    }

}
