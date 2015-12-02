import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

abstract class Ticket
{
    protected String regNum;

    protected Date arrivalTime = null;

    protected boolean prepaid;

    protected Date leavingTime = null;

    public String getRegNum()
    {
        // Returns the registration number
        return regNum;
    }

    public long diffInHours(Date timeNow)
    {
        // Does calculations to set the time stayed at car park
        long diffHours = (timeNow.getTime() - leavingTime.getTime()) / (60 * 60 * 1000);
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
        long diffHours = tickets.diffInHours(timeNow);
        Calendar c = Calendar.getInstance();
        c.setTime(timeNow);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        double cost = 0;
        if (dayOfWeek >= 2 && dayOfWeek <= 5)
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
            if (diffHours <= 1)
            {
                cost = 8.60;
            }
            else if (diffHours <= 2)
            {
                cost = 10.80;
            }
            else
            {
                cost = 25.40;
            }
        }
        if (isPrepaid())
        {
            cost = cost - (cost / 10);
        }
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
        return "[ Machine =========================================]\n"
                + String.format("[ RegNumber: %38s]%n", regNum)
                + String.format("[ Arriving Time: %34s]%n", arrivalTime.toString())
                + ((leavingTime.compareTo(arrivalTime) > 0) ? "[ Prepaid ticket till: " + leavingTime.toString() + "]"
                        : "[Drive in                                          ]")
                + "\n[__________________________________________________]\n";
    }

    public String print(ParkingTicket pt)
    {
        return "[ Ticket ==================]\n"
                + String.format("[ Transaction Number: %5s]\n", pt.getTransactioNumber())
                + String.format("[ RegNumber: %14s]%n", regNum)
                + String.format("[ Length Stayed: %10s]\n", lengthOfTimeStayed(pt.getTimeNow()))
                + String.format("[ Total Cost: %13s]", totalCost(pt.getTimeNow())) + "\n[__________________________]\n";
    }

    public String toStringShort(DateFormat dateFormat)
    {
        return regNum + ", " + dateFormat.format(arrivalTime);
    }

    public long lengthOfTimeStayed(Date timeNow)
    {
        long lengthOfTime;
        lengthOfTime = diffInHours(timeNow);
        return lengthOfTime;

    }

    public String totalCost(Date timeNow)
    {
        String costTotal;
        NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);
        costTotal = GBP.format(calculationCharge(timeNow));

        return costTotal;
    }

    public boolean isPrepaid()
    {
        return prepaid;
    }
}
