import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingTicket
{
    private int transactioNumber = 0;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // creates an instance of this class
        ParkingTicket pt = new ParkingTicket();
        // Makes an instance of the DriveUpParkingClass
        DriveUpParkingTransaction dupTran = new DriveUpParkingTransaction();
        // Creates an array list for the details of each car
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(new Ticket("SY65 OED", new Date(2015, 11, 10, 12, 0), false));
        tickets.add(new Ticket("SY64 ANF", new Date(2015, 11, 10, 9, 0), true, new Date(2015, 11, 10, 21, 0)));
        tickets.add(new Ticket("AX09 WER", new Date(2015, 11, 10, 15, 0), false));
        tickets.add(new Ticket("SW02 DVA", new Date(2015, 11, 10, 6, 0), true, new Date(2015, 11, 10, 8, 0)));
        // Sets a leaving time for each car
        Date timeNow = new Date(2015, 11, 10, 17, 0);
        // Formats the different dates and times
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        DateFormat dateFormatForCreditCard = new SimpleDateFormat("ddMMyyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH, mm");
        // Creates a conditional loop, continue until each ticket has been ran through
        for (Ticket ticket : tickets)
        {
            // Increases the transaction number for each ticket
            int transNum = pt.increaseTransNum();
            // Writes information to the central log
            pt.writeToLogFile("CentralLog.txt",
                    transNum + ", " + pt.ticketInformation(ticket, dupTran, timeNow, dateFormat, timeFormat));
            // Writes information to the Authoristation log
            CreditCardPayment ccp = pt.checkTicket(ticket, timeNow, transNum);
            pt.writeToLogFile("AuthorisationLog.txt", transNum + ", " + (ticket.prepaid ? "D" : "O") + ", "
                    + ccp.creditNumber + ", " + dateFormatForCreditCard.format(ccp.toDate));
        }
    }

    private void writeToLogFile(String fileName, String msg)
    {
        // Creats a file writer
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try
        {
            // Writes the information to each file
            writer = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bufferedWriter != null)
                try
                {
                    bufferedWriter.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            if (writer != null)
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }

    private String ticketInformation(Ticket ticket, DriveUpParkingTransaction dupTran, Date timeNow,
            DateFormat dateFormat, DateFormat timeFormat) throws IOException
    {
        // Sets the information that is to be called and displayed in the central log
        String info;
        long diff = (timeNow.getTime() - ticket.arrivalTime.getTime());
        long diffHours = diff / (60 * 60 * 1000);
        long diffMinutes = diff / (60 * 1000) % 60;
        info = (ticket.regNum + ", " + dateFormat.format(ticket.arrivalTime) + ", "
                + timeFormat.format(ticket.arrivalTime) + ", " + dateFormat.format(ticket.latestLeavingTime) + ", "
                + timeFormat.format(ticket.latestLeavingTime) + ", " + String.format("%02d", diffHours) + ":" + diffMinutes);
        return info;
    }

    public CreditCardPayment checkTicket(Ticket t, Date timeNow, int transNum) throws IOException
    {
        // Sets the display for the console and calls the information to be printed out
        DateFormat dateFormat = new SimpleDateFormat("  dd/MM/yyyy");
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println("      \tPARKING TICKET\n+------------------------------------------------+");
        System.out.println("  Transaction: " + transNum);
        System.out.println(dateFormat.format(timeNow));
        System.out.println("  Regestration Number: " + t.getRegNum());
        CreditCardPayment ccp = test.checkPaid(t, timeNow);
        System.out.println("+------------------------------------------------+");
        return ccp;
    }

    public int increaseTransNum()
    {
        // Increases the transaction number
        transactioNumber++;
        return transactioNumber;
    }
}
