public class Ticket
{
    String regNum;

    double arrivalTime;

    boolean prepaid;

    double latestLeavingTime;

    public String ParkingTicketOne()
    {
        regNum = "SY65 OED";
        arrivalTime = 14.06;
        prepaid = false;
        latestLeavingTime = 16.06;

        return (regNum);
    }

    public String ParkingTicketTwo()
    {
        regNum = "SY64 ANF";
        arrivalTime = 09.58;
        prepaid = true;
        latestLeavingTime = 18.58;

        return (regNum);
    }

    public String ParkingTicketThree()
    {
        regNum = "AX09 WER";
        arrivalTime = 04.40;
        prepaid = false;
        latestLeavingTime = 04.40;

        return (regNum);
    }

    public String ParkingTicketFour()
    {
        regNum = "SW02 DVA";
        arrivalTime = 20.35;
        prepaid = true;
        latestLeavingTime = 21.35;

        return (regNum);
    }
}
