package com.papps.shopping.dto.request;

import com.papps.shopping.entity.enum_.TicketOptions;
import com.papps.shopping.entity.enum_.TicketStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TicketRequestDto {

    private long orderId;

    private String content;

    private long orderProductId;

    TicketStatus status;

    TicketOptions ticketOptions;
}
