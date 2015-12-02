import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TicketTest
{

    Ticket ticketDriveIn = null;

    String regNumb = "SY65 OED";

    @Before
    public void setUp() throws Exception
    {
        ticketDriveIn = new DriveInTicket(regNumb, new Date(2015, 8, 9, 12, 0), false);
    }

    @Test
    public void testIsDriveInTicket()
    {
        assertTrue(ticketDriveIn instanceof Ticket);
        assertTrue(ticketDriveIn instanceof DriveInTicket);
    }

    @Test
    public void testConstructWithException()
    {
        try
        {
            Ticket t = new DriveInTicket("", new Date(), false);
            fail("Should be the IllegalArgumentException");
        }
        catch (IllegalArgumentException iae)
        {
            assertTrue(true);
        }
        catch (Exception e)
        {
            fail("Unknwn exception");
        }
    }

    @Test
    public void testGetRegNum()
    {
        assertEquals(regNumb, ticketDriveIn.getRegNum());

    }

    @Test
    public void testIsValid()
    {
        fail("Not yet implemented");
    }

}
