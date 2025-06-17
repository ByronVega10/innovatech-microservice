package com.innovatech.cart_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // Le dice a Spring que esta clase es una tabla en la base de datos.
@Data   // De Lombok: crea automáticamente getters, setters, toString(), etc.
public class CartItem {

    @Id // Marca este campo como la clave primaria (Primary Key).
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Le dice a MySQL que genere el ID automáticamente.
    private Long id;

    private Long productId; // El ID del producto (vendrá del microservicio de productos).
    private Long customerId; // El ID del cliente (vendrá del microservicio de clientes).
    private int quantity;   // La cantidad de este producto en el carrito.
}
