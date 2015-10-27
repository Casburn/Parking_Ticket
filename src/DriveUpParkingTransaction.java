public class DriveUpParkingTransaction
{
    public void checkPaided()
    {
        Ticket tickets = new Ticket();

        if (tickets.prepaid == false)
        {
            System.out.println("  Ticket Type: Drive In");
        }
        else
        {
            System.out.println("Guess not");
        }
        return;
    }
}
