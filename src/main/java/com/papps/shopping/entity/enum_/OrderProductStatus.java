package com.papps.shopping.entity.enum_;

public enum OrderProductStatus {
    DELIVERED("delivered"), REFUNDED("refunded"), CANCELED("canceled");
    private final String name;

    OrderProductStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
