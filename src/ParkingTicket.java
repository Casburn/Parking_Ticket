import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ParkingTicket
{
    public static void main(String[] args)
    {
        checkTicketOne();
        checkTicketTwo();
        checkTicketThree();
        checkTicketFour();
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
        test.checkPaid(tickets);
        getDate();
    }

    private static void checkTicketTwo()
    {
        Ticket tickets = new Ticket();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println(" \n\tPARKING TICKET\n+-------------------------------+");
        System.out.println("  Transaction: " + transactionNum());
        System.out.println("  Regestration Number: " + tickets.ParkingTicketTwo());
        test.checkPaid(tickets);
        getDate();
    }

    private static void checkTicketThree()
    {
        Ticket tickets = new Ticket();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println(" \n\tPARKING TICKET\n+-------------------------------+");
        System.out.println("  Transaction: " + transactionNum());
        System.out.println("  Regestration Number: " + tickets.ParkingTicketThree());
        test.checkPaid(tickets);
        getDate();
    }

    private static void checkTicketFour()
    {
        Ticket tickets = new Ticket();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println(" \n\tPARKING TICKET\n+-------------------------------+");
        System.out.println("  Transaction: " + transactionNum());
        System.out.println("  Regestration Number: " + tickets.ParkingTicketFour());
        test.checkPaid(tickets);
        getDate();
    }

    private static void getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("  dd/MM/yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
