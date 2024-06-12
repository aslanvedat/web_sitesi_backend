package com.papps.shopping.controller;

import com.papps.shopping.dto.request.TicketRequestDto;
import com.papps.shopping.dto.response.TicketResponseDto;
import com.papps.shopping.entity.Ticket;
import com.papps.shopping.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/")
    public ResponseEntity<Ticket> save(@RequestBody TicketRequestDto input) {
        var result = ticketService.save(input);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDto> view(@PathVariable long id) {
        var result = ticketService.view(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ticket> delete(@PathVariable long id) {
        var result = ticketService.delete(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
