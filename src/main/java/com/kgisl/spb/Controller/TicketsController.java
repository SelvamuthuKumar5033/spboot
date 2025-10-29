package com.kgisl.spb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.spb.Entity.DashboardWrapper;
import com.kgisl.spb.Entity.Tickets;
import com.kgisl.spb.Service.TicketService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
@RestController
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    // public TicketsController(TicketService ticketService) {
    // this.ticketService = ticketService;
    // }

    @GetMapping("/list")
    public ResponseEntity<List<Tickets>> getalltickets() {
        List<Tickets> ticketlist = ticketService.getallTickets();
        System.out.println(ticketlist);
        return ResponseEntity.ok(ticketlist);
    }

    @PostMapping("/add")
    public ResponseEntity<Tickets> addTicket(@RequestBody Tickets tickets) {
        System.out.println(tickets);
        Tickets savedTicket = ticketService.saveTicket(tickets);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Tickets> getoneticket(@PathVariable Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        Tickets oneticket = ticketService.getoneTicket(id);
        return ResponseEntity.ok(oneticket);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tickets> updateticket(@PathVariable Integer id, @RequestBody Tickets tickets) {
        if (tickets == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tickets updatedTickets = ticketService.updateTicket(id, tickets);
        return new ResponseEntity<>(updatedTickets, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tickets> deleteticket(@PathVariable Integer id) {
        if (ticketService.getoneTicket(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<Tickets> statusupdate(@PathVariable Integer id, @RequestBody String status) {
        if (status == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Tickets statusupdaTickets = ticketService.statusupdate(id, status);
        return new ResponseEntity<>(statusupdaTickets, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Tickets>> getUserTickets(@RequestParam("username") String username) {
        if (username == null || username.trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            List<Tickets> userTickets = ticketService.getUsertickets(username.trim());
            if (userTickets == null || userTickets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(userTickets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/dashboard")
    public ResponseEntity<List<DashboardWrapper>> getdashboard(@RequestBody Tickets tickets){
        List<DashboardWrapper> dash = ticketService.getDashboard(tickets);
        return ResponseEntity.ok(dash);
    }
}
