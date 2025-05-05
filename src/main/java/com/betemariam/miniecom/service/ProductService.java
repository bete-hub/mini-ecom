package com.betemariam.miniecom.service;
import com.betemariam.miniecom.dto.ProductDTO;
import com.betemariam.miniecom.exception.ResourceNotFoundException;
import com.betemariam.miniecom.mapper.ProductMapper;
import com.betemariam.miniecom.model.Product;
import com.betemariam.miniecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return ProductMapper.toDTO(product);
    }

    public ProductDTO createProduct(ProductDTO dto) {
        Product saved = productRepository.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDTO(saved);
    }

    public ProductDTO updateProduct(UUID id, ProductDTO dto) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setPrice(dto.getPrice());
        existing.setImageUrl(dto.getImageUrl());

        return ProductMapper.toDTO(productRepository.save(existing));
    }

    public void deleteProduct(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}

