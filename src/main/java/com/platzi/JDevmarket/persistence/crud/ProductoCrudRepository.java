package com.platzi.JDevmarket.persistence.crud;

import com.platzi.JDevmarket.persistence.entity.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    /**
     * Query(value = "select * from productos where id_categoria = ?", nativeQuery = true)
     * List<Producto> getByCategoria(int idCategoria);
     */

    @Query(value = "select * from productos where cantidad_stock < ? and estado = true", nativeQuery = true)
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock);
}
