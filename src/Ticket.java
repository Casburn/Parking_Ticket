import java.util.Date;

public class Ticket
{
    String regNum;

    Date arrivalTime;

    boolean prepaid;

    Date latestLeavingTime;

    double lengthOfTime;

    public Ticket(String regNum, Date arrivalTime, boolean prepaid, Date latestLeavingTime)
    {
        // Creates a constructor that calls the information that is needed
        this.regNum = regNum;
        this.arrivalTime = arrivalTime;
        this.prepaid = prepaid;
        this.latestLeavingTime = latestLeavingTime;
    }

    public Ticket(String regNum, Date arrivalTime, boolean prepaid)
    {
        this.regNum = regNum;
        this.arrivalTime = arrivalTime;
        this.prepaid = prepaid;
        this.latestLeavingTime = arrivalTime;
    }

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
        return diffHours;
    }
}
