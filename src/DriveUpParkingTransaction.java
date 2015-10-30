public class DriveUpParkingTransaction
{
    public void checkPaid(Ticket tickets)
    {
        if (tickets.prepaid)
        {
            PrePaidParkingTransaction prepaidTicket = new PrePaidParkingTransaction();
            System.out.println("  Ticket Type: Pre-Paid");
        }
        else
        {
            System.out.println("  Ticket Type: Drive In");
            System.out.println("  Length of time stayed: " + tickets.driveInLeaveTime() + " hour(s)");
        }
    }
}
