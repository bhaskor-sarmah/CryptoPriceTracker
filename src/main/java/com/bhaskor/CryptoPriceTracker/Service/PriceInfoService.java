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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PriceInfoService {

    static Logger logger = LoggerFactory.getLogger(PriceInfoService.class);
    
    @Autowired
    CryptoPriceRepository cryptoPriceRepository;
    
    public PriceResponse getPriceInfo(Date date, Long offset, Long limit, String currentUrl){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        long pageNo = 0;

        if(offset > 0){
            pageNo = offset/limit;
        }

        Pageable customPageRequest = PageRequest.of((int) pageNo, (int)((long) limit));

        // fetching data from the db
        Page<CryptoPrice> cryptoPrices = cryptoPriceRepository.findByTimestamp(date, customPageRequest);

        // Create the POJO to return as a response
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setData(cryptoPrices.getContent());
        priceResponse.setCount(cryptoPriceRepository.count());
        priceResponse.setUrl(currentUrl+"?date="+sdf.format(date)+"&offset="+offset+"&limit="+limit);
        priceResponse.setNext(currentUrl+"?date="+sdf.format(date)+"&offset="+(offset+limit)+"&limit="+limit);

        return priceResponse;

    }

}
