package com.innovatech.cart_service.controller;

import com.innovatech.cart_service.model.CartItem;
import com.innovatech.cart_service.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Anotación clave: convierte esta clase en un controlador REST.
@RequestMapping("/api/cart") // Define la URL base para todos los endpoints de esta clase.
@RequiredArgsConstructor // Magia de Lombok para la inyección de dependencias.
public class CartController {

    // Inyectamos nuestro servicio para poder usar su lógica.
    private final ICartService cartService;

    // Endpoint para AÑADIR un ítem al carrito
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED) // Devuelve un código 201 Created si todo va bien.
    public void addItemToCart(@RequestBody CartItem cartItem) {
        cartService.addItemToCart(cartItem);
    }

    // Endpoint para OBTENER todos los ítems de un cliente
    @GetMapping("/{customerId}")
    public ResponseEntity<List<CartItem>> getCartByCustomerId(@PathVariable Long customerId) {
        List<CartItem> cartItems = cartService.getCartByCustomerId(customerId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    // Endpoint para ELIMINAR un ítem del carrito
    @DeleteMapping("/delete/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve un código 204 No Content si se borra con éxito.
    public void deleteItemFromCart(@PathVariable Long itemId) {
        cartService.deleteItemFromCart(itemId);
    }
}
