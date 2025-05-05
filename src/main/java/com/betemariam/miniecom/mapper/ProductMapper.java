package com.betemariam.miniecom.mapper;

import com.betemariam.miniecom.dto.ProductDTO;
import com.betemariam.miniecom.model.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
    }

    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
                .id(dto.getId()) // For update only
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .build();
    }
}

