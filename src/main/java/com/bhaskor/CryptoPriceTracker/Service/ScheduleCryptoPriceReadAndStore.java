package com.bhaskor.CryptoPriceTracker.Service;

import java.util.Date;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;
import com.bhaskor.CryptoPriceTracker.Repositories.CryptoPriceRepository;
import com.bhaskor.CryptoPriceTracker.Response.BitcoinPrice;
import com.bhaskor.CryptoPriceTracker.Util.EmailUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduleCryptoPriceReadAndStore {

    static Logger logger = LoggerFactory.getLogger(ScheduleCryptoPriceReadAndStore.class);

    @Autowired
    CryptoPriceRepository cryptoPriceRepository;

    @Value("${coin.type}")
    String coinType;

    @Value("${currency.type}")
    String currencyType;

    @Value("${max.price}")
    Long maxPrice;

    @Value("${min.price}")
    Long minPrice;

    @Value("${user.email}")
    String userEmail;

    @Scheduled(fixedRate = 30000)
    public void getAndProcessPriceDetailsFromApi() {
        try {

            String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=inr";

            // Fetching data from the restApi
            logger.info("Fetching price details for coin type: " + coinType + " currency type: " + currencyType);
            RestTemplate restTemplate = new RestTemplate();
            BitcoinPrice obj = restTemplate.getForObject(url, BitcoinPrice.class);

            // Extracting the price from the response
            Long price = obj.getBitcoin().get(currencyType);

            System.out.println("Price => "+price);
            if (logger.isDebugEnabled()) {
                logger.debug("Received price value: " + price);
            }

            // Trigger Email When price cross the max value
            if (price > maxPrice) {
                if(!EmailUtil.fireEmail(userEmail, price, coinType, currencyType)){
                    logger.error("Error while firing email to emailId: "+userEmail);
                }
            }

            // Trigger Email When price cross the min value
            if (price < minPrice) {
                if(!EmailUtil.fireEmail(userEmail, price, coinType, currencyType)){
                    logger.error("Error while firing email to emailId: "+userEmail);
                }
            }

            // Persisting the data into the DB
            savePriceDetailsToDb(price, coinType, currencyType);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private void savePriceDetailsToDb(Long price, String coinType, String currencyType) {
        // Creating CryptoPrice object to persist into the DB
        CryptoPrice cryptoPrice = new CryptoPrice();

        cryptoPrice.setCoinType(coinType);
        cryptoPrice.setPrice(price);
        cryptoPrice.setTimestamp(new Date());
        cryptoPrice.setCurrencyType(currencyType);

        // Saving to DB
        cryptoPriceRepository.save(cryptoPrice);
    }

}
