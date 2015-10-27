import java.util.Random;

public class ParkingTicket
{
    public static void main(String[] args)
    {
        checkTicketOne();
        checkTicketTwo();
    }

    private static int transactionNum()
    {
        Random ran = new Random();
        int number = ran.nextInt(900) + 100;
        return number;
    }

    private static void checkTicketOne()
    {
        Ticket tickets = new Ticket();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println(" \tPARKING TICKET\n+-------------------------------+");
        System.out.println("  Transaction: " + transactionNum());
        System.out.println("  Regestration Number: " + tickets.ParkingTicketOne());
        test.checkPaidOne(tickets);
    }

    private static void checkTicketTwo()
    {
        Ticket tickets = new Ticket();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println(" \n\tPARKING TICKET\n+-------------------------------+");
        System.out.println("  Transaction: " + transactionNum());
        System.out.println("  Regestration Number: " + tickets.ParkingTicketTwo());
        test.checkPaidTwo(tickets);
    }
}
