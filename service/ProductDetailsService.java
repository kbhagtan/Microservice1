package com.product.details.productdetailsservice.service;

import com.product.details.productdetailsservice.pojos.ProductDetails;

import java.util.List;


public interface ProductDetailsService {

   public  void saveProductDetails(ProductDetails productDetails);

   public List<ProductDetails> getProductDetailsList();

   public void addItemToCart(int quantity,String prodName);
}
