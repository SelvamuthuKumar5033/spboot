package com.kgisl.spb.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.spb.Entity.Tickets;
import com.kgisl.spb.Repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    // public TicketService(TicketRepository ticketRepository) {
    // this.ticketRepository = ticketRepository;
    // }

    public List<Tickets> getallTickets() {
        return ticketRepository.findAll();
    }

    public Tickets saveTicket(Tickets tickets) {
        return ticketRepository.save(tickets);
    }

    public Tickets getoneTicket(Integer id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Tickets updateTicket(Integer id, Tickets newTickets) {
        Tickets oldTicket = ticketRepository.findById(id).orElse(null);

        if (oldTicket != null) {
            Tickets updatedTicket = new Tickets(
                    oldTicket.sid(),
                    newTickets.ticketerid(),
                    newTickets.ticketername(),
                    newTickets.ticketdate(),
                    newTickets.ticketdesc(),
                    newTickets.tickettime());

            return ticketRepository.save(updatedTicket);
        }
        return null;
    }

    public void deleteTicket(Integer id) {
        ticketRepository.deleteById(id);
        return;
    }

}
