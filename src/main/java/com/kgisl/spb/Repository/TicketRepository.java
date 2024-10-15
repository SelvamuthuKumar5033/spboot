package com.kgisl.spb.Repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.spb.Entity.Tickets;

@Repository
public interface TicketRepository extends ListCrudRepository<Tickets,Integer>{

}
