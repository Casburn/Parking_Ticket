import java.util.Date;

public class PrePaidParkingTransaction
{
    public double prepaidParking(Ticket tickets)
    {
        CreditCardPayment creditCard = new CreditCardPayment();
        double cost = 0;

        Date timeNow = new Date(2015, 11, 10, 17, 0);
        // try{
        // // SimpleDateFormat sdf = new SimpleDateFormat(" K:mm");
        // Date date1 = sdf.parse(tickets.arrivalTime)
        // }

        if (tickets.latestLeavingTime == timeNow)
        {
            System.out.println("  TICKET PAID");
            System.out.println("  Length of time stayed: " + stay);
        }
        else
        {
            if (stay <= 1)
            {
                cost = 4.70;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (stay > 1 && stay <= 2)
            {
                cost = 7.40;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (stay >= 3 && stay <= 4)
            {
                cost = 10.30;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (stay >= 5 && stay <= 6)
            {
                cost = 14.80;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (stay >= 7 && stay <= 9)
            {
                cost = 17.80;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (stay >= 10 && stay <= 12)
            {
                cost = 20.20;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (stay >= 13 && stay <= 24)
            {
                cost = 23.70;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            System.out.println("  Length of time stayed: " + stay);
            creditCard.creditCardDetails();
        }
        return stay;
    }
}
