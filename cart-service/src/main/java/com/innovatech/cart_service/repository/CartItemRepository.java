package com.innovatech.cartservice.repository;

import com.innovatech.cartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Le dice a Spring que esta es una interfaz de acceso a datos.
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    // Spring Data JPA creará automáticamente una consulta para buscar por el ID del cliente.
    List<CartItem> findByCustomerId(Long customerId);
}
