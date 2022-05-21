package com.bhaskor.CryptoPriceTracker.Controller;

import com.bhaskor.CryptoPriceTracker.Response.PriceResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/prices/")
public class PriceInfoController {
    

    @RequestMapping(method = RequestMethod.GET, path = "btc")
    public ResponseEntity<PriceResponse> getBtcPrice(@RequestParam("date") String date, @RequestParam("offset") Long offset, @RequestParam("limit") Long limit){

        PriceResponse response = new PriceResponse();

        response.setCount(5L);

        return ResponseEntity.ok(response);
    }

}
