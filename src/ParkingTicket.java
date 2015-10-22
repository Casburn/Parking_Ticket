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

        for (int i = 0; i < 1; i++)
        {
            int num = random.nextInt(900) + 100;
            System.out.println(" Transaction Number: " + num);
        }

    }

    public void timeArrived()
    {
        Random rand = new Random();

        for (int i = 0; i < 1; i++)
        {
            int hour = rand.nextInt(24) + 0;
        }
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
        System.out.println(" Parking Ticket \n+--------------------------+");
        transactionNum();
    }
}
