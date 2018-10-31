package com.product.details.productdetailsservice.service;

import com.product.details.productdetailsservice.pojos.ProductDetails;
import com.product.details.productdetailsservice.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Override
    public void saveProductDetails(ProductDetails productDetails) {
        productDetailsRepository.save(productDetails);
    }

    @Override
    public List<ProductDetails> getProductDetailsList() {
        List<ProductDetails> productDetails = productDetailsRepository.findAllByQuantityGreaterThanZero();
        return  productDetails;
    }

    @Override
    public void addItemToCart(int quantity, String prodName) {
        productDetailsRepository.removeProductDetailsByQuantityAndProductName(quantity,prodName);
    }
}
