import java.util.Date;

public class DriveUpParkingTransaction
{
    CreditCardPayment creditCard = new CreditCardPayment();

    public CreditCardPayment checkPaid(Ticket ticket, Date timeNow)
    {
        // Checks if the ticket is a prepaid or drive up
        if (ticket.prepaid)
        {
            // If it is prepaid, prints out prepaid
            PrePaidParkingTransaction prepaidTicket = new PrePaidParkingTransaction();
            System.out.println("  Ticket Type: Pre-Paid");
            prepaidTicket.prepaidParking(ticket, timeNow);
            return prepaidTicket.creditCard;
        }
        else
        {
            // If it is drive up prints out drive in and calls the calculations for time stayed
            System.out.println("  Ticket Type: Drive In");
            System.out.println("  Length of time stayed: " + ticket.calculationCharge(ticket, timeNow) + " hour(s)");
            // creditCard.creditCardDetails();
            return creditCard;
        }
    }

}
