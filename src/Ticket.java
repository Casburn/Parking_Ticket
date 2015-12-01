import java.util.Calendar;
import java.util.Date;

abstract class Ticket
{
    String regNum;

    Date arrivalTime = null;

    boolean prepaid;

    Date latestLeavingTime = null;

    double lengthOfTime;

    public String getRegNum()
    {
        // Returns the registration number
        return regNum;
    }

    public long differentHours(Date timeNow)
    {
        // Does calculations to set the time stayed at car park
        long diffHours = (timeNow.getTime() - latestLeavingTime.getTime()) / (60 * 60 * 1000);
        // Returns the time stayed

        if (diffHours < 0)
        {
            diffHours = diffHours - diffHours - diffHours;
        }
        return diffHours;
    }

    public double calculationCharge(Date timeNow)
    {
        return calculationCharge(this, timeNow);
    }

    public double calculationCharge(Ticket tickets, Date timeNow)
    {
        // Calls calculation for time stayed and checks for what the cost will be and returns

        Calendar c = Calendar.getInstance();
        c.setTime(timeNow);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        long diffHours = tickets.differentHours(timeNow);
        double cost = 0;
        if (c.DAY_OF_WEEK >= 2 && c.DAY_OF_WEEK <= 6)
        {
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
        }
        else
        {
            if (diffHours > 0 && diffHours <= 1)
            {
                cost = 8.60;
            }
            else if (diffHours > 1 && diffHours <= 2)
            {
                cost = 10.80;
            }
            else
            {
                cost = 25.40;
            }

        }
        System.out.println("  Cost: £" + cost);
        return cost;
    }

    public boolean isValid()
    {
        // FIX - validation
        return true;
    }

    @Override
    public String toString()
    {
        return "Ticket[ RegNumbeR: " + regNum + "]";
    }
}
