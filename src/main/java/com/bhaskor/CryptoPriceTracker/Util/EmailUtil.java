package com.bhaskor.CryptoPriceTracker.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {

    static Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    public static boolean fireEmail(String emailId, Long price, String coinType, String currencyType) {
        logger.info("Fire Email Logic Triggered for emailId: " + emailId + " and price: " + price + ", coin type: "
                + coinType + ", currency type: " + currencyType);
        return true;
    }

}
