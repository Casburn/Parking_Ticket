public class Ticket
{
    String regNum;

    String regNum2;

    double arrivalTime;

    boolean prepaid1;

    boolean prepaid2;

    double latestLeavingTime;

    public void main(String[] args)
    {
        System.out.println(ParkingTicketOne());
        System.out.println(ParkingTicketTwo());
    }

    public String ParkingTicketOne()
    {
        regNum = "SY65 OED";
        arrivalTime = 14.06;
        prepaid1 = false;
        latestLeavingTime = 16.06;

        return (regNum);
    }

    public String ParkingTicketTwo()
    {
        regNum2 = "SY64 ANF";
        arrivalTime = 09.58;
        prepaid2 = true;
        latestLeavingTime = 18.58;

        return (regNum2);
    }
}
