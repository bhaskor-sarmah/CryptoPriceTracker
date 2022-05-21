package com.bhaskor.CryptoPriceTracker.Repositories;

import java.util.Date;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoPriceRepository extends JpaRepository<CryptoPrice, Long>{
        Page<CryptoPrice> findByTimestamp(Date timestamp, Pageable page);
}
