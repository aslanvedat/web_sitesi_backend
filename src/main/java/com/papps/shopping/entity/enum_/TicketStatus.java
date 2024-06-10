package com.papps.shopping.entity.enum_;

public enum TicketStatus {
    REQUEST_GENERATED("reguest_generated"), UNDER_REVIEW("under_review"), FINALIZED("finalized");
    private final String name;

    TicketStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
