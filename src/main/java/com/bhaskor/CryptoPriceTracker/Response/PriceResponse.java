package com.bhaskor.CryptoPriceTracker.Response;

import java.util.ArrayList;
import java.util.List;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;


public class PriceResponse {
    
    Long count;

    List<CryptoPrice> data = new ArrayList<>();


    public PriceResponse() {
    }


    public PriceResponse(Long count, List<CryptoPrice> data) {
        this.count = count;
        this.data = data;
    }


    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<CryptoPrice> getData() {
        return this.data;
    }

    public void setData(List<CryptoPrice> data) {
        this.data = data;
    }

}
