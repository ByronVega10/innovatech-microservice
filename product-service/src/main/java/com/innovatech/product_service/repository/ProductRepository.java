package com.innovatech.product_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.innovatech.product_service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findById(Integer id);

    Product findByNombre(String nombre);

    List<Product> findByNombreAndDescripcion(String nombre, String descripcion);

}
