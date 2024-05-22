package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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
