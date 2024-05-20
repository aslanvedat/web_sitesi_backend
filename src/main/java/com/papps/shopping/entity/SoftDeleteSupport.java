package com.papps.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "SoftDeleteSupport")
public abstract class SoftDeleteSupport {

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name = "deletionToken")
    private UUID deletionToken;
}
