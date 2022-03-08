package com.example.theater.Ticket;

import com.example.theater.Movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theater/tickets")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired TicketService ticketService;

    @GetMapping
    List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping(path = "{ticketId}")
    public Ticket getTicketId(
            @PathVariable("ticketId") Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @PostMapping
    Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @DeleteMapping(path = "{ticketId}")
    public void deleteTicket(
            @PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicket(ticketId);
    }
}


