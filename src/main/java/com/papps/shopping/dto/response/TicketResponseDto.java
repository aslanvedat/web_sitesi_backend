package com.papps.shopping.dto.response;

import com.papps.shopping.entity.Order;
import com.papps.shopping.entity.OrderProduct;
import com.papps.shopping.entity.Ticket;
import com.papps.shopping.entity.enum_.TicketOptions;
import com.papps.shopping.entity.enum_.TicketStatus;
import lombok.Data;

@Data
public class TicketResponseDto {
    private long id;

    private Order order;

    private String content;

    private OrderProduct orderProduct;

    TicketStatus status;

    TicketOptions ticketOptions;

    public TicketResponseDto(Ticket ticket) {
        this.id = ticket.getId();
        this.order = ticket.getOrder();
        this.content = ticket.getContent();
        this.orderProduct = ticket.getOrderProduct();
        this.status = ticket.getStatus();
        this.ticketOptions = ticket.getTicketOptions();
    }
}
