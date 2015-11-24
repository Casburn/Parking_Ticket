import java.util.Date;

public class WeekdayCharge
{
    // Manages weekday charges and returns a charge based on the length of stay

    // Rename method, make a new if with costs nested within it, else the weekend charge, if needs to find what day in
    // the week it is.
    public double driveInLeaveTime(Ticket tickets, Date timeNow)
    {
        /*
         * Calendar c = Calendar.getInstance();
         * c.setTime(yourDate);
         * int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
         */

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
        double cost = 0;

        if (diffHours > 0 && diffHours <= 1)
        {
            cost = 8.60;
            System.out.println("  Cost: £" + cost);
        }
        else if (diffHours > 1 && diffHours <= 2)
        {
            cost = 10.80;
            System.out.println("  Cost: £" + cost);
        }
        else
        {
            cost = 25.40;
            System.out.println("  Cost: £" + cost);
        }
        return cost;
    }
}
