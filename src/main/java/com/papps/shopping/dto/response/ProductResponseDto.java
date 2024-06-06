package com.papps.shopping.dto.response;

import com.papps.shopping.entity.Product;
import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;

    private String name;

    private String barcode;

    private int quantity;

    private float price;

    private boolean isShow;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.barcode = product.getBarcode();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.isShow = product.isShow();//todo burada bi sorun var
    }
}
