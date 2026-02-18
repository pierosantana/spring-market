package com.market.persistence;

import com.market.domain.Purchase;
import com.market.domain.repository.PurchaseRepository;
import com.market.persistence.crud.CompraCrudRepository;
import com.market.persistence.entity.Compra;
import com.market.persistence.entity.Producto;
import com.market.persistence.mapper.PurchaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    CompraCrudRepository compraCrudRepository;
    PurchaseMapper mapper;

    public CompraRepository(CompraCrudRepository compraCrudRepository, PurchaseMapper mapper) {
        this.compraCrudRepository = compraCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return mapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByCLientId(String clientId) {
        List<Compra> compras = compraCrudRepository.findByClienteId(clientId);
        List<Purchase> purchases = mapper.toPurchases(compras);
        return purchases.isEmpty() ? Optional.empty() : Optional.of(purchases);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
