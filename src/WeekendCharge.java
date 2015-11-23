import java.util.Date;

public class WeekendCharge(Ticket tickets, Date timeNow)
{
    // managaes the weekend charges and returns a charge based on the length of stay
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
}
}
