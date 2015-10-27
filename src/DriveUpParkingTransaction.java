public class DriveUpParkingTransaction
{
    public static String checkPaided()
    {
        Ticket tickets = new Ticket();

        if (tickets.ParkingTicketOne() == "Drive In")
        {
            System.out.println("Working");
        }
        else
        {
            System.out.println("Guess not");
        }
        return null;
    }
}
