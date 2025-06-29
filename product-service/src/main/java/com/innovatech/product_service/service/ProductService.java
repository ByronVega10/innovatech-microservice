package com.innovatech.product_service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innovatech.product_service.model.Product;
import com.innovatech.product_service.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findbyId(long id){
        return productRepository.findById(id).get();
    }

    public Product save(Product producto){
        return productRepository.save(producto);
    }

    public void delet(Long id){
        productRepository.deleteById(id);
    }
}
