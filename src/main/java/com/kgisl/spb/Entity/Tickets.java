package com.kgisl.spb.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


public record Tickets(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) int sid,
        String ticketerid,
        String ticketername,
        String ticketdate,
        String ticketdesc,
        String tickettime) {
}
