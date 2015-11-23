import java.util.Date;

public class WeekdayCharge
{
    // Manages weekday charges and returns a charge based on the length of stay

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
