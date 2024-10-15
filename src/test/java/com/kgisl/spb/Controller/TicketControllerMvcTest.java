// package com.kgisl.spb.Controller;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class TicketControllerMvcTest {
//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     public void getallTicketsTest() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/app"))
//                 .andExpect(status().isOk());
//     }
//     @Test
//     public void getticketByIdTest() throws Exception {
//         int sid = 1; // Adjust this ID based on your test data
//         mockMvc.perform(MockMvcRequestBuilders.get("/app/{id}", sid))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//     }
    
//     @Test
//     public void createticketTest() throws Exception {
//         String newPersonJson = "{\"ticketerid\":\"27\",\"ticketername\":\"selba\",\"ticketerdate\":\"05-05-2023\",\"ticketerdesc\":\"meantime\",\"ticketertime\":\"12:03\"}";
//         mockMvc.perform(MockMvcRequestBuilders.post("/app")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(newPersonJson))
//                 .andExpect(status().isCreated())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//     }

//     @Test
//     public void updateticketTest() throws Exception {
//         int sid = 30; // Adjust this ID based on your test data
//         String updatedPersonJson = "{\"ticketerid\":\"27\",\"ticketername\":\"selvaa\",\"ticketerdate\":\"05-05-2023\",\"ticketerdesc\":\"meantime\",\"ticketertime\":\"12:03\"}";
//         mockMvc.perform(MockMvcRequestBuilders.put("/app/{id}",sid)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(updatedPersonJson))
//                 .andExpect(status().isCreated())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//     }

//     @Test
//     public void deleteticketTest() throws Exception {
//         int sid = 20; // Adjust this ID based on your test data
//         mockMvc.perform(MockMvcRequestBuilders.delete("/app/{id}", sid))
//                 .andExpect(status().isNoContent());
//     }
// }
