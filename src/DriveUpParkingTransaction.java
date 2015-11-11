import java.util.Date;

public class DriveUpParkingTransaction
{
    public void checkPaid(Ticket tickets, Date timeNow)
    {
        if (tickets.prepaid)
        {
            PrePaidParkingTransaction prepaidTicket = new PrePaidParkingTransaction();
            System.out.println("  Ticket Type: Pre-Paid");
            prepaidTicket.prepaidParking(tickets, timeNow);
        }
        else
        {
            CreditCardPayment creditCard = new CreditCardPayment();
            System.out.println("  Ticket Type: Drive In");
            System.out.println("  Length of time stayed: " + driveInLeaveTime(tickets, timeNow) + " hour(s)");
            creditCard.creditCardDetails();
        }
    }

    public double driveInLeaveTime(Ticket tickets, Date timeNow)
    {
        long diffHours = (timeNow.getTime() - tickets.latestLeavingTime.getTime()) / (60 * 60 * 1000);

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
        return diffHours;
    }
}
