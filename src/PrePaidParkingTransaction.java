import java.util.Date;

public class PrePaidParkingTransaction
{
    CreditCardPayment creditCard = new CreditCardPayment();

    public double prepaidParking(Ticket tickets, Date timeNow)
    {

        double cost = 0;
        long diffHours = tickets.differentHours(timeNow);
        // If they havent over stayed then Ticket paid is printed
        if (diffHours <= 0)
        {
            System.out.println("  Length of time stayed: " + diffHours);
            System.out.println("  TICKET PAID");
        }
        else
        {
            // If they over stay, it is checked how long for
            if (diffHours <= 1)
            {
                cost = 4.70;

            }
            else if (diffHours <= 2)
            {
                cost = 7.40;
            }
            else if (diffHours <= 4)
            {
                cost = 10.30;
            }
            else if (diffHours <= 6)
            {
                cost = 14.80;
            }
            else if (diffHours <= 9)
            {
                cost = 17.80;
            }
            else if (diffHours <= 12)
            {
                cost = 20.20;
            }
            else if (diffHours <= 24)
            {
                cost = 23.70;
            }
            // Calls credit card details and prints out length stayed
            System.out.println("  Length of time stayed: " + diffHours);
            // creditCard.creditCardDetails();
        }
        System.out.println("  Cost: £" + (cost - (cost / 10)));
        // Returns cost
        return cost;
    }

}
