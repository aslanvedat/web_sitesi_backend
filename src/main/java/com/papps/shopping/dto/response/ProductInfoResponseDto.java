package com.papps.shopping.dto.response;

import com.papps.shopping.entity.ProductInfo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Map;

@Data
public class ProductInfoResponseDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private Map<String, String> metaData;

    private String barcode;

    public ProductInfoResponseDto(ProductInfo productInfo) {
        this.id = productInfo.getId();
        this.name = productInfo.getName();
        this.metaData = productInfo.getMetaData();
        this.barcode = productInfo.getBarcode();

    }
}
