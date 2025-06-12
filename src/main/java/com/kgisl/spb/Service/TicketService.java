package com.kgisl.spb.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kgisl.spb.Entity.DashboardWrapper;
import com.kgisl.spb.Entity.Tickets;
import com.kgisl.spb.Repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
                    oldTicket.getSid(),
                    newTickets.getTicketerid(),
                    newTickets.getTicketername(),
                    newTickets.getTicketdate(),
                    newTickets.getTicketdesc(),
                    newTickets.getTickettime(),
                    newTickets.getStatus());

            return ticketRepository.save(updatedTicket);
        }
        return null;
    }

    public Tickets statusupdate(Integer id, String status) {
        Tickets oldTicket = ticketRepository.findById(id).orElse(null);
        if (status != null && oldTicket != null) {
            oldTicket.setStatus(status);
            return ticketRepository.save(oldTicket);
        }
        return null;
    }

    public void deleteTicket(Integer id) {
        ticketRepository.deleteById(id);
        return;
    }

    @SuppressWarnings("deprecation")
    public List<Tickets> getUsertickets(String username) {
        return jdbcTemplate.query(
                "{call GetUserTickets(?)}",
                new Object[] { username },
                new BeanPropertyRowMapper<>(Tickets.class));
    }

    @SuppressWarnings("deprecation")
    public List<DashboardWrapper> getDashboard(Tickets tic) {

        String sql = "SELECT COUNT(*) AS total, " +
                "SUM(CASE WHEN ticketdate = ? THEN 1 ELSE 0 END) AS todayticket, " +
                "SUM(CASE WHEN status = 'pending' THEN 1 ELSE 0 END) AS pending, " +
                "SUM(CASE WHEN status = 'inprogress' THEN 1 ELSE 0 END) AS inprogress " +
                "FROM tickets ";

        RowMapper<DashboardWrapper> rowMapper = new BeanPropertyRowMapper<>(DashboardWrapper.class);

        if (!tic.getTicketername().equals("admin")) {
            sql += "WHERE ticketername = ? ;";
            System.out.println(sql);
            return jdbcTemplate.query(sql, new Object[]{tic.getTicketdate(),tic.getTicketername()} ,rowMapper);
        }   
        return jdbcTemplate.query(sql, new Object[]{tic.getTicketdate()} ,rowMapper);

    }

}
