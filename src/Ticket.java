public class Ticket
{
    String regNum;

    double arrivalTime;

    Boolean prepaid = false;

    double latestLeavingTime;

    public void main(String[] args)
    {
        System.out.println(ParkingTicketOne());
    }

    public String ParkingTicketOne()
    {
        regNum = "SY65 OED";
        arrivalTime = 14.06;
        prepaid = false;
        latestLeavingTime = 16.06;

        return (regNum);

    }
}
