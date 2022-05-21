package com.bhaskor.CryptoPriceTracker.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;
import com.bhaskor.CryptoPriceTracker.Repositories.CryptoPriceRepository;
import com.bhaskor.CryptoPriceTracker.Response.PriceResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceInfoService {

    static Logger logger = LoggerFactory.getLogger(PriceInfoService.class);
    
    @Autowired
    CryptoPriceRepository cryptoPriceRepository;
    
    public PriceResponse getPriceInfo(Date date, Long offset, Long limit){
        // fetching data from the db
        List<CryptoPrice> cryptoPrices = cryptoPriceRepository.findByTimestamp(date);

        // Create the POJO to return as a response
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setData(cryptoPrices);
        priceResponse.setCount(cryptoPriceRepository.count());

        return priceResponse;

    }

}
