package com.bhaskor.CryptoPriceTracker.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.bhaskor.CryptoPriceTracker.Response.ErrorResponse;
import com.bhaskor.CryptoPriceTracker.Response.PriceResponse;
import com.bhaskor.CryptoPriceTracker.Service.PriceInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/prices/")
public class PriceInfoController {
    static Logger logger = LoggerFactory.getLogger(PriceInfoController.class);

    @Autowired
    PriceInfoService priceInfoService;

    @RequestMapping(method = RequestMethod.GET, path = "btc")
    public ResponseEntity<?> getBtcPrice(HttpServletRequest request, @RequestParam("date") String dateStr, @RequestParam("offset") Long offset,
            @RequestParam("limit") Long limit) {
        String currentUrl = request.getRequestURI();

        // Verifying Date Data
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            logger.error("Invalid Date Format Received", e);
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Invalid date format received ! Expected format DD-MM-YYYY", 400, null));
        }

        // Verifying Offset and Limit
        if(offset < 0 || limit <= 0){
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Invalid offset or limit received", 400, null));
        }

        if(offset%limit != 0){
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Offset Should be equally divisible by limit", 400, null));
        }

        return ResponseEntity.ok(priceInfoService.getPriceInfo(date, offset, limit, currentUrl));
    }

}
