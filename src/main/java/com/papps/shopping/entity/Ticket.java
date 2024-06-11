package com.papps.shopping.entity;

import com.papps.shopping.entity.enum_.TicketOptions;
import com.papps.shopping.entity.enum_.TicketStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

@Entity
@Data
@Table(name = "ticket", uniqueConstraints = {@UniqueConstraint(columnNames = {"deleted", "deletion_token"})})
@SQLDelete(sql = "UPDATE ticket SET deleted=true, deletion_token = id WHERE id=?")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    Order order;

    private String Content;
    OrderProduct orderProduct;

    @Enumerated(EnumType.STRING)
    TicketStatus status;

    @Enumerated(EnumType.STRING)
    TicketOptions ticketOptions;
}
