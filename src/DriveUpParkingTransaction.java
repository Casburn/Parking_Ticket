import java.util.Date;

public class DriveUpParkingTransaction
{
    public CreditCard checkPaid(Ticket ticket, Date timeNow)
    {
        User user = new User(null, null, ticket);
        // CreditCard creditCard = new CreditCard(pin, number, expire)
        // Checks if the ticket is a prepaid or drive up
        if (ticket.prepaid)
        {
            // If it is prepaid, prints out prepaid
            // PrePaidParkingTransaction prepaidTicket = new PrePaidParkingTransaction();
            System.out.println("  Ticket Type: Pre-Paid");
            // prepaidTicket.prepaidParking(ticket, timeNow);
            ticket.calculationCharge(timeNow);
            return user.getCreditCard();
        }
        else
        {
            // If it is drive up prints out drive in and calls the calculations for time stayed
            System.out.println("  Ticket Type: Drive In");
            System.out.println("  Length of time stayed: " + ticket.calculationCharge(ticket, timeNow) + " hour(s)");
            return user.getCreditCard();
        }
    }

}
