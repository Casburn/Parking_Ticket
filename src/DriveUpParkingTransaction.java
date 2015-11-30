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
            System.out.println("  Length of time stayed: " + driveInLeaveTime(ticket, timeNow) + " hour(s)");
            // creditCard.creditCardDetails();
            return creditCard;
        }
    }

    public double driveInLeaveTime(Ticket tickets, Date timeNow)
    {
        // Calls calculation for time stayed and checks for what the cost will be and returns
        long diffHours = tickets.differentHours(timeNow);
        double cost = 0;

        if (diffHours > 0 && diffHours <= 1)
        {
            cost = 4.70;
            System.out.println("  Cost: £" + cost);
        }
        else if (diffHours > 1 && diffHours <= 2)
        {
            cost = 7.40;
            System.out.println("  Cost: £" + cost);
        }
        else if (diffHours >= 3 && diffHours <= 4)
        {
            cost = 10.30;
            System.out.println("  Cost: £" + cost);
        }
        else if (diffHours >= 5 && diffHours <= 6)
        {
            cost = 14.80;
            System.out.println("  Cost: £" + cost);
        }
        else if (diffHours >= 7 && diffHours <= 9)
        {
            cost = 17.80;
            System.out.println("  Cost: £" + cost);
        }
        else if (diffHours >= 10 && diffHours <= 12)
        {
            cost = 20.20;
            System.out.println("  Cost: £" + cost);
        }
        else if (diffHours >= 13 && diffHours <= 24)
        {
            cost = 23.70;
            System.out.println("  Cost: £" + cost);
        }
        return cost;
    }
}
