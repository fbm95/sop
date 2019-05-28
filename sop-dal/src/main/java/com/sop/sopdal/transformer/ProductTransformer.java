package com.sop.sopdal.transformer;

import com.sop.sopdal.domain.Product;
import com.sop.sopdal.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformer implements Transformer<Product, ProductDTO> {

    @Override
    public Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setWeight(dto.getWeight());
        entity.setDescription(dto.getDescription());
        entity.setRestaurant(dto.getRestaurant());
        return entity;
    }

    @Override
    public ProductDTO toDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setWeight(entity.getWeight());
        dto.setDescription(entity.getDescription());
        dto.setRestaurant(entity.getRestaurant());
        return dto;
    }
}
