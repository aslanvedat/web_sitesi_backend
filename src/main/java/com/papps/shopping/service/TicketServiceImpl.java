package com.papps.shopping.service;

import com.papps.shopping.dto.request.TicketRequestDto;
import com.papps.shopping.dto.response.TicketResponseDto;
import com.papps.shopping.entity.Ticket;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final OrderService orderService;
    private final OrderProductService orderProductService;

    @Override
    public Ticket findById(long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElseThrow(() -> new ApiRequestException("ticket is not found!"));
    }

    @Override
    public Ticket save(TicketRequestDto input) {
        Ticket ticket = new Ticket();
        ticket.setContent(input.getContent());
        ticket.setStatus(input.getStatus());
        ticket.setTicketOptions(input.getTicketOptions());
        var result = input.getOrderId();
        var order = orderService.findById(result);
        ticket.setOrder(order);
        var result2 = input.getOrderProductId();
        var orderProduct = orderProductService.findById(result2);
        ticket.setOrderProduct(orderProduct);
        return ticketRepository.save(ticket);
    }

    @Override
    public TicketResponseDto view(long id) {
        var result = findById(id);
        return new TicketResponseDto(result);
    }

    @Override
    public Ticket delete(long id) {
        var result = findById(id);
        ticketRepository.delete(result);
        return result;
    }
}
