package com.papps.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @CreatedBy
    protected String createdBy;

    @Column(name = "createdTime")
    protected LocalDateTime CreatedTime;

    @Column(name = "modifiedTime")
    protected LocalDateTime modifiedTime;

    @LastModifiedDate
    protected String modifiedBy;

}
