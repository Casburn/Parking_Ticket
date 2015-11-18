import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParkingTicketTest
{

    ParkingTicket parkingTicket;

    Ticket ticket;

    @Test
    public void testRegestrationNumberOne()
    {
        assertEquals("SY63 ANF", ticket.regNum);
    }

    @Test
    public void testTransactionNumber()
    {
        assertEquals("1", parkingTicket.increaseTransNum());
    }
}
