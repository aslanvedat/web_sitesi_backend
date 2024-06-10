package com.papps.shopping.entity.enum_;

public enum TicketOptions {
    CHANGE("change"), REFUNDED("refunded"), STOCK("stock");
    private final String name;

    TicketOptions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
