package com.innovatech.cart_service.service;

import com.innovatech.cart_service.model.CartItem;
import java.util.List;

public interface ICartService {

    List<CartItem> getCartByCustomerId(Long customerId);

    void addItemToCart(CartItem cartItem);

    void deleteItemFromCart(Long itemId);
}
