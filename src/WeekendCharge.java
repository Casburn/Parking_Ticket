import java.util.Date;

public class WeekendCharge(Ticket tickets, Date timeNow)
{
    // managaes the weekend charges and returns a charge based on the length of stay
    
    double[] cost = new double[24];
    {
        cost[0] = 0;
        cost[1] = 4.70;
        cost[2] = 7.40;
        cost[3] = 10.30;
        cost[4] = 10.30;
        cost[5] = 14.80;
        cost[6] = 14.80;
        cost[7] = 17.80;
        cost[8] = 17.80;
        cost[9] = 17.80;
        cost[10] = 20.20;
        cost[11] = 20.20;
        cost[12] = 20.20;
        cost[13] = 23.70;
        cost[14] = 23.70;
        cost[15] = 23.70;
        cost[16] = 23.70;
        cost[18] = 23.70;
        cost[19] = 23.70;
        cost[20] = 23.70;
        cost[21] = 23.70;
        cost[23] = 23.70;
        cost[24] = 23.70;
    }
    
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
}
}
