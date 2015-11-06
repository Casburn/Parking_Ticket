import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ParkingTicket
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        ParkingTicket pt = new ParkingTicket();
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(new Ticket("SY65 OED", false));
        tickets.add(new Ticket("SY64 ANF", 09.58, true, 18.58));
        tickets.add(new Ticket("AX09 WER", false));
        tickets.add(new Ticket("SW02 DVA", 20.35, true, 22.35));
        try
        {
            FileWriter writer = new FileWriter("CentralLog.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Hello World");
            bufferedWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for (Ticket ticket : tickets)
        {
            pt.checkTicket(ticket);
        }

    }

    private static int transactionNum()
    {
        Random ran = new Random();
        int number = ran.nextInt(900) + 100;
        return number;
    }

    public void checkTicket(Ticket t)
    {
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println("      \tPARKING TICKET\n+------------------------------------------------+");
        System.out.println("  Transaction: " + transactionNum());
        getDate();
        System.out.println("  Regestration Number: " + t.getRegNum());
        test.checkPaid(t);
        System.out.println("+------------------------------------------------+");
    }

    private static void getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("  dd/MM/yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
