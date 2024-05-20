package com.papps.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Auditable")
public abstract class Auditable extends SoftDeleteSupport{

@Column(name = "createdBy")
    private User createdBy;
@Column(name = "createdTime")
    private LocalDateTime CreatedTime;

@Column(name = "modifiedTime")
    private LocalDateTime modifiedTime;

@Column(name = "modifiedBy")
    private User modifiedBy;


}
