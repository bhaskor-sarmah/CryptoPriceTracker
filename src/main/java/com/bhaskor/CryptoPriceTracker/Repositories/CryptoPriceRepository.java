package com.bhaskor.CryptoPriceTracker.Repositories;

import com.bhaskor.CryptoPriceTracker.Model.CryptoPrice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoPriceRepository extends JpaRepository<Long, CryptoPrice>{
    
    

}
