public class Ticket
{
    String regNum;

    double arrivalTime;

    boolean prepaid;

    double latestLeavingTime;

    double lengthOfTime;

    public String ParkingTicketOne()
    {
        regNum = "SY65 OED";
        arrivalTime = 14.06;
        prepaid = false;
        latestLeavingTime = 16.06;
        lengthOfTime = 2.00;

        return (regNum);
    }

    public String ParkingTicketTwo()
    {
        regNum = "SY64 ANF";
        arrivalTime = 09.58;
        prepaid = true;
        latestLeavingTime = 18.58;
        lengthOfTime = 9.00;

        return (regNum);
    }

    public String ParkingTicketThree()
    {
        regNum = "AX09 WER";
        arrivalTime = 04.40;
        prepaid = false;
        latestLeavingTime = 04.40;
        lengthOfTime = 25.47;

        return (regNum);
    }

    public String ParkingTicketFour()
    {
        regNum = "SW02 DVA";
        arrivalTime = 20.35;
        prepaid = true;
        latestLeavingTime = 21.35;
        lengthOfTime = 7.41;

        return (regNum);
    }
}
