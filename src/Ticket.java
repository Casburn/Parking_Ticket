public class Ticket
{
    public static void main(String[] args)
    {
        System.out.println(ParkingTicketOne());
    }

    public static String ParkingTicketOne()
    {
        String regNum1 = "SY65 OED";
        int arrivalTime1 = 1406;
        String prepaid1 = "Drive In";
        int latestLeavingTime1 = 1606;

        return (regNum1 + "\n" + arrivalTime1 + "\n" + prepaid1 + "\n" + latestLeavingTime1);

    }
}
