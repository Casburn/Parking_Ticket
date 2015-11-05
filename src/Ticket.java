public class Ticket
{
    String regNum;

    double arrivalTime;

    boolean prepaid;

    double latestLeavingTime;

    double lengthOfTime;

    public Ticket(String regNum, boolean prepaid)
    {
        this.regNum = regNum;
        this.prepaid = prepaid;
    }

    public Ticket(String regNum, double arrivalTime, boolean prepaid, double latestLeavingTime)
    {
        this.regNum = regNum;
        this.arrivalTime = arrivalTime;
        this.prepaid = prepaid;
        this.latestLeavingTime = latestLeavingTime;
    }

    public String getRegNum()
    {
        return regNum;
    }

    public String toStringcsvStyle()
    {
        return regNum + "," + arrivalTime + "," + prepaid + "," + latestLeavingTime + "," + lengthOfTime;
    }
}
