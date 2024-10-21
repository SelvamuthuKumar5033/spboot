package com.kgisl.spb.Entity;

import org.springframework.data.annotation.Id;

public record Tickets(
        @Id int sid,
        String ticketerid,
        String ticketername,
        String ticketdate,
        String ticketdesc,
        String tickettime) {
}
