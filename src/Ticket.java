import java.util.Random;
import java.util.Scanner;

public class Ticket
{
    String regNum;

    double arrivalTime;

    boolean prepaid;

    double latestLeavingTime;

    double lengthOfTime;

    public String ParkingTicketOne()
    {
        // drive in
        regNum = "SY65 OED";
        // arrivalTime = 14.06;
        prepaid = false;

        return (regNum);
    }

    public String ParkingTicketTwo()
    {
        // prepaid
        regNum = "SY64 ANF";
        arrivalTime = 09.58;
        prepaid = true;
        latestLeavingTime = 18.58;

        return (regNum);
    }

    public String ParkingTicketThree()
    {
        // drive in
        regNum = "AX09 WER";
        // arrivalTime = 04.40;
        prepaid = false;

        return (regNum);
    }

    public String ParkingTicketFour()
    {
        // prepaid
        regNum = "SW02 DVA";
        arrivalTime = 20.35;
        prepaid = true;
        latestLeavingTime = 22.35;

        return (regNum);
    }

    public double driveInLeaveTime()
    {
        Scanner keyboard = new Scanner(System.in);

        Random ran = new Random();
        double number = ran.nextInt(24);

        double cost = 0;
        if (number > 0 && number <= 1)
        {
            cost = 4.70;
            System.out.println("  Cost: £" + cost);
        }
        else if (number > 1 && number <= 2)
        {
            cost = 7.40;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 3 && number <= 4)
        {
            cost = 10.30;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 5 && number <= 6)
        {
            cost = 14.80;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 7 && number <= 9)
        {
            cost = 17.80;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 10 && number <= 12)
        {
            cost = 20.20;
            System.out.println("  Cost: £" + cost);
        }
        else if (number >= 13 && number <= 24)
        {
            cost = 23.70;
            System.out.println("  Cost: £" + cost);
        }

        return number;
    }
}
