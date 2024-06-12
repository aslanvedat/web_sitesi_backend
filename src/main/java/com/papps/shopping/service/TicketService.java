package com.papps.shopping.service;

import com.papps.shopping.dto.request.TicketRequestDto;
import com.papps.shopping.dto.response.TicketResponseDto;
import com.papps.shopping.entity.Ticket;

public interface TicketService {
    Ticket findById(long id);

    Ticket save(TicketRequestDto input);

    TicketResponseDto view(long id);

    Ticket delete(long id);
}
