package com.innovatech.cart_service.service;

import com.innovatech.cart_service.model.CartItem;
import com.innovatech.cart_service.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final CartItemRepository cartRepository;

    @Override
    @Transactional(readOnly = true) // Optimizada para operaciones de solo lectura.
    public List<CartItem> getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    @Transactional // Esta es la anotación clave para las operaciones de escritura.
    public void addItemToCart(CartItem cartItem) {
        cartRepository.save(cartItem);
    }

    @Override
    @Transactional
    public void deleteItemFromCart(Long itemId) {
        cartRepository.deleteById(itemId);
    }
}
