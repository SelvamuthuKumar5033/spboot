// package com.kgisl.spb.Controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import java.util.HashMap;
// import java.util.Map;

// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestInstance;

// import com.microsoft.playwright.APIRequest;
// import com.microsoft.playwright.APIRequestContext;
// import com.microsoft.playwright.APIResponse;
// import com.microsoft.playwright.Playwright;
// import com.microsoft.playwright.options.RequestOptions;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// public class TicketControllerApiTest {

//     private Playwright playwright;
//     private APIRequestContext request;

//     @BeforeAll
//     void beforeAll() {
//         createPlaywright();
//         createAPIRequestContext();
//     }

//     void createPlaywright() {
//         playwright = Playwright.create();
//     }

//     void createAPIRequestContext() {
//         Map<String, String> headers = new HashMap<>();
//         // We set this header per your developer guidelines.
//         // headers.put("Accept", "application/json");
//         // Add authorization token to all requests.
//         // Assuming personal access token available in the environment.
//         // headers.put("Authorization", "token " + API_TOKEN);

//         request = playwright.request().newContext(new APIRequest.NewContextOptions()
//                 // All requests we send go to this API endpoint.
//                 .setBaseURL("http://localhost:8080")
//                 .setExtraHTTPHeaders(headers));
//     }

//     void disposeAPIRequestContext() {
//         if (request != null) {
//             request.dispose();
//             request = null;
//         }
//     }

//     void closePlaywright() {
//         if (playwright != null) {
//             playwright.close();
//             playwright = null;
//         }
//     }

//     @AfterAll
//     void afterAll() {
//         disposeAPIRequestContext();
//         closePlaywright();
//     }

//     @Test
//     void getallTicketsTest() {
//         // SELECT count(*) FROM PERSON
//         // http://localhost:10000/person
//         // https://jsonpathfinder.com/

//         APIResponse response = request.get("/app");

//         assertEquals(200, response.status());


//         // JsonArray json = new Gson().fromJson(response.text(), JsonArray.class);
//         // assertEquals(json.size(), json.size());
//         // // JsonElement firstValue = json.get(0);
//         // Tickets tickets = new Gson().fromJson(json.get(0), Tickets.class);

//         // assertEquals(tickets.ticketerid(), 11);
//         // assertEquals(tickets.ticketername(), "Vignesh");
//         // assertEquals(tickets.ticketdesc(), "Software Installation");
//         // assertEquals(tickets.ticketdate(), "2024-08-27");
//         // assertEquals(tickets.tickettime(), "09:41");
//     }

//     @Test
//     void createTicketsTest() {
//         Map<String, String> data = new HashMap<>();
//         data.put("ticketerid", "11");
//         data.put("ticketername", "jesu");
//         data.put("ticketdesc", "abcd");
//         data.put("ticketdate", "05-05-2023");
//         data.put("tickettime", "09:11");


//         APIResponse response = request.post("/app", RequestOptions.create().setData(data));

//         // Tickets person = new Gson().fromJson(response.text(), Tickets.class);

//         assertEquals(201, response.status());
//         // assertEquals("OK", response.statusText());

//         // assertEquals(person.uname(), "Jesu");
//         // assertEquals(person.email(), "jesu@email.com");
//     }

//     @Test
//     void getticketbyidTest() {
//         // http://localhost:10000/person/5
//         // {"id":5,"firstName":"Emily","lastName":"Davis","email":"emily.davis@example.com"}

//         APIResponse response = request.get("app/2");

//         // Tickets person = new Gson().fromJson(response.text(), Tickets.class);

//         assertEquals(200, response.status());
//         // assertEquals("OK", response.statusText());
//     }

//     @Test
//     void deleteTicketTest() {
    
//         APIResponse response = request.delete("/app/2");
//         assertEquals(204, response.status());
//     }

//     @Test
//     void updatedTicketsTest() {
        
//         Map<String, String> data = new HashMap<>();
//         data.put("ticketerid", "5");
//         data.put("ticketername", "Jesudoss");
//         data.put("ticketdate", "09-09-2023");
//         data.put("ticketdesc", "abcd");
//         data.put("tickettime", "09:09");

//         APIResponse response = request.put("/app/1", RequestOptions.create().setData(data));
//         // Tickets person = new Gson().fromJson(response.text(), Tickets.class);
//         assertEquals(201, response.status());
//         // assertEquals(person.uname(), "Jesudoss");
//         // assertEquals(person.email(), "jesudoss@gmail.com");
//     }
// }
