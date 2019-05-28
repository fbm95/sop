package com.sop.sopdal.service;

import com.sop.sopdal.domain.Product;
import com.sop.sopdal.dto.ProductDTO;
import com.sop.sopdal.repository.ProductRepository;
import com.sop.sopdal.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductTransformer transformer;

    public List<Product> getAllProductsFor(Long restaurantId) {
        return this.repository.findAllByRestaurantId(restaurantId);
    }

    public Product transformAndSave(ProductDTO dto) {
        return this.save(this.transformer.toEntity(dto));
    }

    public Product save(Product entity) {
        return this.repository.save(entity);
    }

    public Product getProductById(Long productId) {
        return this.repository.findProductById(productId);
    }

    public BigDecimal computeTotalForProductsIn(List<ProductDTO> products){
        return this.repository.totalSumForProducts(products.stream().map(ProductDTO::getId).collect(Collectors.toList()));
    }

}
