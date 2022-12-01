package com.example.supermarket.service;

import com.example.supermarket.model.Product;
import com.example.supermarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product persist(Product product) {
        return productRepository.save(product);
    }

    public Product geById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        return null;
    }

    public Product update(String id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            //existingProduct.setImage(product.getImage());
            existingProduct.setSectorId(product.getSectorId());
            existingProduct.setExpirationDate(product.getExpirationDate());
            existingProduct.setProductionDate(product.getProductionDate());

        }
        return productRepository.save(product);
    }


    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
