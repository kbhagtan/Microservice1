package com.product.details.productdetailsservice.controller;

import com.product.details.productdetailsservice.pojos.ProductDetails;
import com.product.details.productdetailsservice.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @PostMapping("/saveProductDetails")
    public void saveProductDetails(@RequestBody ProductDetails productDetails)
    {
        productDetailsService.saveProductDetails(productDetails);
    }

    @GetMapping("/productDetails")
    public List<ProductDetails> getAllProductDetails()
    {
        return productDetailsService.getProductDetailsList();
    }

    @GetMapping("/removeProductFromCart/{quantity}/{productName}")
    public String productCart(@RequestParam int quantity, String productName) throws IOException {

        productDetailsService.addItemToCart(quantity,productName);
        return "Added to cart";
    }
}
