import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//import com.csvreader.CsvWriter;

public class ParkingTicket
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ParkingTicket pt = new ParkingTicket();
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(new Ticket("SY65 OED", false));
        tickets.add(new Ticket("SY64 ANF", 09.58, true, 18.58));
        tickets.add(new Ticket("AX09 WER", false));
        tickets.add(new Ticket("SW02 DVA", 20.35, true, 22.35));

        for (Ticket ticket : tickets)
        {
            pt.checkTicket(ticket);
        }
        PrintWriter pw = new PrintWriter(new File("Test.txt"));
        StringBuilder sb = new StringBuilder();

        sb.append("transaction number");
        sb.append("Registration Number");
        sb.append("Date of Transaction");
        sb.append("Arrival Time");
        sb.append("Exit Time");
        sb.append("Total Time");
        sb.append("Total Cost");

        pw.write(sb.toString());
        pw.close();
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
