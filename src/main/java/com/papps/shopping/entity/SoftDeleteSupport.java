package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
public abstract class SoftDeleteSupport {


    @Column(name = "deleted")
    private boolean deleted;

    @Id
    @Column(name = "deletionToken")
    private UUID deletionToken;
}
