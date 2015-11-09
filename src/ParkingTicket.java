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

        BufferedWriter bufferedWriter = null;
        try
        {
            FileWriter writer = new FileWriter("CentralLog.txt", false);
            bufferedWriter = new BufferedWriter(writer);
            for (Ticket ticket : tickets)
            {
                pt.checkTicket(ticket);
                bufferedWriter.write(pt.ticketInformation(ticket));
                bufferedWriter.newLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bufferedWriter != null)
                bufferedWriter.close();
        }

    }

    private String ticketInformation(Ticket ticket)
    {
        String info;

        info = (ticket.regNum + ", " + ticket.arrivalTime + ", " + ticket.lengthOfTime + ", ");

        return info;
    }

    private static int transactionNum() throws IOException
    {
        Random ran = new Random();
        int number = ran.nextInt(900) + 100;

        return number;
    }

    public void checkTicket(Ticket t) throws IOException
    {
        int transNum = transactionNum();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println("      \tPARKING TICKET\n+------------------------------------------------+");
        System.out.println("  Transaction: " + transNum);
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
