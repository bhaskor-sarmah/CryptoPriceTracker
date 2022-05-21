package com.bhaskor.CryptoPriceTracker.Repositories;

import java.util.Date;
import java.util.List;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoPriceRepository extends JpaRepository<CryptoPrice, Long>{
        List<CryptoPrice> findByTimestamp(Date timestamp);
}
