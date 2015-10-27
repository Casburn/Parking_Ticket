import java.util.Random;

public class ParkingTicket
{
    public static void main(String[] args)
    {
        Ticket tickets = new Ticket();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println("Transaction: " + transactionNum());
        System.out.println(tickets.ParkingTicketOne());
        System.out.println(test.checkPaided());
    }

    private static int transactionNum()
    {
        Random ran = new Random();
        int number = ran.nextInt(900) + 100;
        return number;
    }
}
