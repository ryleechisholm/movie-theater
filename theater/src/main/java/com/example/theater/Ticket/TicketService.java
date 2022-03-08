package com.example.theater.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long ticketId) {
        return ticketRepository.findTicketById2(ticketId);
    }

    public void addNewTicket(Ticket ticket) {
        Optional<Ticket> ticketOptional = ticketRepository.findTicketById(ticket.getId());
    }

    public void deleteTicket(Long ticketId) {
        boolean exists = ticketRepository.existsById(ticketId);
        if (!exists) {
            throw new IllegalStateException(("ticket with id "  + ticketId + " does not exist"));
        }
        ticketRepository.deleteById(ticketId);
    }
}
