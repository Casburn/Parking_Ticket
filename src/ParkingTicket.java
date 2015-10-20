public class ParkingTicket
{
    public String regNum;

    public int hours, minutes;

    public boolean prepaid;

    public int leavingTime, arrivalTime;

    public void validTicket()
    {
        this.prepaid = false;
    }

    public void timeRemaining()
    {
        // to do
    }

    public void arrivalTime()
    {
        this.arrivalTime = 1200;
    }
}
