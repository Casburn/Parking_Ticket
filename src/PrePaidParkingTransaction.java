import java.util.Random;

public class PrePaidParkingTransaction
{
    Random ran = new Random();

    double number = ran.nextInt(24);

    double cost = 0;
    {
        if (number <= 1)
        {
            cost = 4.70;
            System.out.println("  Cost: £" + cost);
        }
        else if (number > 1 && number <= 2)
        {
            cost = 7.40;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 3 && number <= 4)
        {
            cost = 10.30;
            System.out.println("  Cost: £");
        }
        else if (number >= 5 && number <= 6)
        {
            cost = 14.80;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 7 && number <= 9)
        {
            cost = 17.80;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 10 && number <= 12)
        {
            cost = 20.20;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 13 && number <= 24)
        {
            cost = 23.70;
            System.out.println("  Cost: £" + cost);
        }
    }
}
