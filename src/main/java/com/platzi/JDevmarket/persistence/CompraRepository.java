package com.platzi.JDevmarket.persistence;

import com.platzi.JDevmarket.domain.Purchase;
import com.platzi.JDevmarket.domain.repositories.PurchaseRepository;
import com.platzi.JDevmarket.persistence.crud.ComprasCrudRespository;
import com.platzi.JDevmarket.persistence.entity.Compra;
import com.platzi.JDevmarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private ComprasCrudRespository comprasCrudRespository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) comprasCrudRespository.findAll();
        return mapper.toPurchases(compras);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return comprasCrudRespository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(comprasCrudRespository.save(compra));
    }
}
