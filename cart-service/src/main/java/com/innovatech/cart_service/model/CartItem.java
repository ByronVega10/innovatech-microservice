package com.innovatech.cart_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;      
import jakarta.validation.constraints.NotNull; 
import lombok.Data;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del producto no puede ser nulo.") // Regla 1
    private Long productId;

    @NotNull(message = "El ID del cliente no puede ser nulo.")   // Regla 2
    private Long customerId;

    @NotNull(message = "La cantidad no puede ser nula.")         // Regla 3
    @Min(value = 1, message = "La cantidad debe ser al menos 1.") // Regla 4
    private Integer quantity; // Cambiado a Integer para permitir la anotación @NotNull
}
