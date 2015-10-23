import java.util.Random;
//import java.io.FileReader;
//import java.util.Scanner;

public class ParkingTicket
{

    public String regNum;

    public static boolean prepaid;

    public int leavingTime, arrivalTime;

    public static void timeArrived()
    {
        Random rand = new Random();

        for (int i = 0; i < 1; i++)
        {
            int hour = rand.nextInt(24) + 0;
            int minute = rand.nextInt(60) + 0;
            System.out.printf(" Time Arrived: " + "%02d:%02d\n", hour, minute);
        }
    }

    public static void validTicket()
    {
        if (prepaid == true)
        {
            System.out.println(" PREPAID TICKET");
        }
        else
        {
            System.out.println(" DRIVE IN TICKET");
        }
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

    public void timeRemaining()
    {
        // to do
    }

    public static void main(String[] args)
    {
        Ticket[] tickets = new Ticket[4];

        System.out.println(" Parking Ticket \n+--------------------------+");
        transactionNum();
        timeArrived();
        validTicket();
    }
}
