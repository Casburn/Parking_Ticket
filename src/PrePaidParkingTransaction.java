import java.util.Random;

public class PrePaidParkingTransaction
{
    public double prepaidParking()
    {
        Random ran = new Random();

        double number = ran.nextInt(24);

        double cost = 0;
        {
            if (number <= 1)
            {
                cost = 4.70;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (number > 1 && number <= 2)
            {
                cost = 7.40;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (number >= 3 && number <= 4)
            {
                cost = 10.30;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (number >= 5 && number <= 6)
            {
                cost = 14.80;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (number >= 7 && number <= 9)
            {
                cost = 17.80;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (number >= 10 && number <= 12)
            {
                cost = 20.20;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
            else if (number >= 13 && number <= 24)
            {
                cost = 23.70;
                System.out.println("  Cost: £" + (cost - (cost / 10)));
            }
        }
        return (cost - (cost / 10));
    }

    public double lenthOfStay()
    {
        Random ran = new Random();
        int stay = ran.nextInt(13);
        return stay;
    }

    public void overStay(Ticket tickets)
    {
        if (lenthOfStay() < (tickets.latestLeavingTime - tickets.arrivalTime))
        {
            System.out.println("TICKET PAID");
        }
        else
        {
            prepaidParking();
        }
    }
}
