package com.bhaskor.CryptoPriceTracker.Response;

import java.util.ArrayList;
import java.util.List;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;


public class PriceResponse {
    
    Long count;

    List<CryptoPrice> data = new ArrayList<>();

    String url;

    String next;


    public PriceResponse() {
    }



    public PriceResponse(Long count, List<CryptoPrice> data, String url, String next) {
        this.count = count;
        this.data = data;
        this.url = url;
        this.next = next;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNext() {
        return this.next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
