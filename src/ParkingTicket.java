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
        DriveUpParkingTransaction dupTran = new DriveUpParkingTransaction();
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(new Ticket("SY65 OED", new Date(2015, 11, 10, 12, 0), false));
        tickets.add(new Ticket("SY64 ANF", new Date(2015, 11, 10, 9, 0), true, new Date(2015, 11, 10, 21, 0)));
        tickets.add(new Ticket("AX09 WER", new Date(2015, 11, 10, 15, 0), false));
        tickets.add(new Ticket("SW02 DVA", new Date(2015, 11, 10, 6, 0), true, new Date(2015, 11, 10, 8, 0)));
        Date timeNow = new Date(2015, 11, 10, 17, 0);
        BufferedWriter bufferedWriter = null;
        try
        {
            FileWriter writer = new FileWriter("CentralLog.txt", false);
            bufferedWriter = new BufferedWriter(writer);
            for (Ticket ticket : tickets)
            {
                pt.checkTicket(ticket, timeNow);
                bufferedWriter.write(pt.ticketInformation(ticket, dupTran));
                bufferedWriter.write("");
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

    private String ticketInformation(Ticket ticket, DriveUpParkingTransaction dupTran)
    {
        String info;
        info = (ticket.regNum + ", " + ticket.arrivalTime + ", " + ticket.lengthOfTime + ", " + ticket.latestLeavingTime);
        return info;
    }

    private static int transactionNum() throws IOException
    {
        Random ran = new Random();
        int number = ran.nextInt(900) + 100;
        return number;
    }

    public void checkTicket(Ticket t, Date timeNow) throws IOException
    {
        int transNum = transactionNum();
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println("      \tPARKING TICKET\n+------------------------------------------------+");
        System.out.println("  Transaction: " + transNum);
        getDate();
        System.out.println("  Regestration Number: " + t.getRegNum());
        test.checkPaid(t, timeNow);
        // System.out.println(test.driveInLeaveTime(t, timeNow));
        System.out.println("+------------------------------------------------+");
    }

    private static void getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("  dd/MM/yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
