// package com.kgisl.spb.Controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.List;
// import java.util.Arrays;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.kgisl.spb.Entity.Tickets;
// import com.kgisl.spb.Service.TicketService;

// @ExtendWith(MockitoExtension.class)
// public class TicketControllerTest {

//     @Mock
//     private TicketService ticketService;

//     @InjectMocks
//     private TicketsController ticketsController;

//     public static List<Tickets> expected;

//     Tickets t1 = new Tickets(1, 24, "Selva", "2024-08-29", "Software Installation", "12:34:00");
//     Tickets t2 = new Tickets(2, 18, "Dhanush", "2024-08-29", "Desktop Repair", "01:34:00");

//     @Test
//     public void getallTicketsTest() {

//         expected = Arrays.asList(t1, t2);
//         System.out.println(expected);
//         when(ticketService.getallTickets()).thenReturn(expected);
//         ResponseEntity<List<Tickets>> actual = ticketsController.getalltickets();
//         assertNotNull(actual);
//         assertEquals(expected, actual.getBody());
//         assertEquals(HttpStatus.OK, actual.getStatusCode());
//     }

//     @Test
//     public void createticketTest() {
//         when(ticketService.saveTicket(t1)).thenReturn(t1);
//         ticketsController.addTicket(t1);
//     }

//     @Test
//     public void getticketByIdTest() {
//         int id = 1;
//         when(ticketService.getoneTicket(id)).thenReturn(null);
//         ResponseEntity<Tickets> actual = ticketsController.getoneticket(id);
//         assertNotNull(actual);
//     }

//     @Test
//     public void updateticketTest() {
//         // Person edit = new PersonBuilder().name("shanmugam").build();
//         int id = 1;
//         // when(personService.updatePerson(id, person1)).thenReturn(person1);
//         ResponseEntity<Tickets> actual = ticketsController.updateticket(id, t1);
//         assertNotNull(actual);
//         System.out.println("Actual is  " + actual.getBody());
//         System.out.println("expected-->" + expected);
//         // assertEquals(edit, actual.getBody());
//     }

//     @Test
//     public void deleteticketTest() {
//         int id = 1;
//         when(ticketService.getoneTicket(id)).thenReturn(t1);
//         ticketsController.deleteticket(id);
//         verify(ticketService).deleteTicket(id);
//     }
// }
