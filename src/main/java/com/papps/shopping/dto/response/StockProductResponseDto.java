package com.papps.shopping.dto.response;

import com.papps.shopping.entity.ProductInfo;
import com.papps.shopping.entity.StockProduct;
import lombok.Data;

@Data
public class StockProductResponseDto {
    private long id;

    ProductInfo productInfo;

    private float price;

    private int quantity;

    public StockProductResponseDto(StockProduct stockProduct) {
        this.id = stockProduct.getId();
        this.productInfo = stockProduct.getProductInfo();
        this.price = stockProduct.getPrice();
        this.quantity = stockProduct.getQuantity();
    }
}
