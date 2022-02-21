package com.appsdeveloperbog.estore.productsservice.query;

import com.appsdeveloperbog.estore.productsservice.core.dat.ProductsRepository;
import com.appsdeveloperbog.estore.productsservice.core.data.ProductEntity;
import com.appsdeveloperbog.estore.productsservice.core.events.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventsHandler {

    private final ProductsRepository productsRepository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);

        productsRepository.save(productEntity);
    }
}
