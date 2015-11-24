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

        System.out.println("  Cost: £" + cost);
        return cost;
    }

    public int weekendCharge(Ticket tickets, Date timeNow)
    {
        long diffHours = tickets.differentHours(timeNow);
        double cost1 = 0;

        if (diffHours > 0 && diffHours <= 1)
        {
            cost1 = 8.60;
            System.out.println("  Cost: £" + cost1);
        }
        else if (diffHours > 1 && diffHours <= 2)
        {
            cost1 = 10.80;
            System.out.println("  Cost: £" + cost1);
        }
        else
        {
            cost1 = 25.40;
            System.out.println("  Cost: £" + cost1);
        }
        return cost1;
    }
}
