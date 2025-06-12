package com.kgisl.spb.Entity;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;


// public record Tickets(
//         @Id int sid,
//         String ticketerid,
//         String ticketername,
//         String ticketdate,
//         String ticketdesc,
//         String tickettime) {
// }



@Entity
@Table(name = "tickets")
public class Tickets {

    @Id
    private int sid;

    @Column(name = "ticketerid")
    private String ticketerid;

    @Column(name = "ticketername")
    private String ticketername;

    @Column(name = "ticketdate")
    private String ticketdate;

    @Column(name = "ticketdesc")
    private String ticketdesc;

    @Column(name = "tickettime")
    private LocalTime tickettime;

    @Column(name = "status")
    private String status ;

    public Tickets() {
    }

    public Tickets(int sid, String ticketerid, String ticketername, String ticketdate, String ticketdesc, LocalTime tickettime,String status) {
        this.sid = sid;
        this.ticketerid = ticketerid;
        this.ticketername = ticketername;
        this.ticketdate = ticketdate;
        this.ticketdesc = ticketdesc;
        this.tickettime = tickettime;
        this.status = status;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTicketerid() {
        return ticketerid;
    }

    public void setTicketerid(String ticketerid) {
        this.ticketerid = ticketerid;
    }

    public String getTicketername() {
        return ticketername;
    }

    public void setTicketername(String ticketername) {
        this.ticketername = ticketername;
    }

    public String getTicketdate() {
        return ticketdate;
    }

    public void setTicketdate(String ticketdate) {
        this.ticketdate = ticketdate;
    }

    public String getTicketdesc() {
        return ticketdesc;
    }

    public void setTicketdesc(String ticketdesc) {
        this.ticketdesc = ticketdesc;
    }

    public LocalTime getTickettime() {
        return tickettime;
    }

    public void setTickettime(LocalTime tickettime) {
        this.tickettime = tickettime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}