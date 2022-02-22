package com.appsdeveloperbog.estore.productsservice.query;

import com.appsdeveloperbog.estore.productsservice.core.dat.ProductsRepository;
import com.appsdeveloperbog.estore.productsservice.core.data.ProductEntity;
import com.appsdeveloperbog.estore.productsservice.query.rest.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductsQueryHandler {

    private final ProductsRepository productsRepository;

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {
        List<ProductRestModel> productsRest = new ArrayList<>();

        List<ProductEntity> storedProducts = productsRepository.findAll();

        storedProducts.forEach(productEntity -> {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productsRest.add(productRestModel);
        });

        return productsRest;
    }

}
