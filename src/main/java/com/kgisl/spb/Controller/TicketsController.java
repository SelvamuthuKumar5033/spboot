package com.kgisl.spb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.spb.Entity.Tickets;
import com.kgisl.spb.Service.TicketService;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tickets")
@RestController
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Tickets>> getalltickets() {
        List<Tickets> ticketlist = ticketService.getallTickets();
        System.out.println(ticketlist);
        return ResponseEntity.ok(ticketlist);
    }

    
    @PostMapping
    public ResponseEntity<Tickets> addTicket(@RequestBody Tickets tickets) {
        System.out.println(tickets);
        Tickets savedTicket = ticketService.saveTicket(tickets);
        return new ResponseEntity<>(savedTicket,HttpStatus.CREATED);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Tickets> getoneticket(@PathVariable Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        Tickets oneticket = ticketService.getoneTicket(id);
        return ResponseEntity.ok(oneticket);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Tickets> updateticket(@PathVariable Integer id, @RequestBody Tickets tickets) {
        if (tickets == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tickets updatedTickets = ticketService.updateTicket(id, tickets);
        return new ResponseEntity<>(updatedTickets, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Tickets> deleteticket(@PathVariable Integer id) {
        if (ticketService.getoneTicket(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
