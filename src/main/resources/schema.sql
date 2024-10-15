
CREATE TABLE if NOT EXISTS Tickets (
    sid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ticketerid VARCHAR(10),
    ticketername VARCHAR(50),
    ticketdate VARCHAR(10),
    ticketdesc VARCHAR(50),
    tickettime VARCHAR(10)
);
