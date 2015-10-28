public class DriveUpParkingTransaction
{
    public void checkPaid(Ticket tickets)
    {
        if (tickets.prepaid)
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
