public class DriveUpParkingTransaction
{

    public void checkPaidOne(Ticket tickets)
    {
        if (tickets.prepaid1)
        {
            System.out.println("  Ticket Type: Pre-Paid");
        }
        else
        {
            System.out.println("  Ticket Type: Drive In");
        }

    }

    public void checkPaidTwo(Ticket tickets)
    {
        if (tickets.prepaid2)
        {
            System.out.println("  Ticket Type: Pre-Paid");
        }
        else
        {
            System.out.println("  Ticket Type: Drive In");
        }
    }
}
// PrePaidParkingTransaction prepaidTicket = new PrePaidParkingTransaction();
