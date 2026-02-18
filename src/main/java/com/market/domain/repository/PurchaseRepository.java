package com.market.domain.repository;

import com.market.domain.Purchase;
import com.market.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByCLientId(String clientId);
    Purchase save(Purchase purchase);
}
