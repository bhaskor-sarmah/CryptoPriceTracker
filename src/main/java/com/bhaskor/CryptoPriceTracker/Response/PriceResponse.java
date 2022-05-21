package com.bhaskor.CryptoPriceTracker.Response;

import java.util.HashSet;
import java.util.Set;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;


public class PriceResponse {
    
    Long count;

    Set<CryptoPrice> data = new HashSet<>();


    public PriceResponse() {
    }


    public PriceResponse(Long count, Set<CryptoPrice> data) {
        this.count = count;
        this.data = data;
    }


    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Set<CryptoPrice> getData() {
        return this.data;
    }

    public void setData(Set<CryptoPrice> data) {
        this.data = data;
    }

}
