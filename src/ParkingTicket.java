import java.util.Random;

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

    public static void transactionNum()
    {
        Random random = new Random();

        int num = random.nextInt(900);

    }

    public void timeRemaining()
    {
        // to do
    }

    public void arrivalTime()
    {
        this.arrivalTime = 1200;
    }

    public static void main(String[] args)
    {
        transactionNum();
    }
}
