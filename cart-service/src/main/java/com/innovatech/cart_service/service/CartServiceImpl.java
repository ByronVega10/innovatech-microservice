package com.innovatech.cart_service.service;

import com.innovatech.cart_service.model.CartItem;
import com.innovatech.cart_service.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marca esta clase como un componente de servicio de Spring.
@RequiredArgsConstructor // Magia de Lombok: crea un constructor para los campos 'final'.
public class CartServiceImpl implements ICartService {

    // Inyección de Dependencias: Spring nos dará automáticamente una instancia del repositorio.
    private final CartItemRepository cartRepository;

    @Override
    public List<CartItem> getCartByCustomerId(Long customerId) {
        // Le pedimos al repositorio que busque los ítems por el ID del cliente.
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    public void addItemToCart(CartItem cartItem) {
        // Simplemente guardamos el ítem que nos pasan.
        cartRepository.save(cartItem);
    }

    @Override
    public void deleteItemFromCart(Long itemId) {
        // Le pedimos al repositorio que borre el ítem usando su ID.
        cartRepository.deleteById(itemId);
    }
}
