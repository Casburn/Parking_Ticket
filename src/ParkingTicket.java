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
        // DriveUpParkingTransaction dupTran = new DriveUpParkingTransaction();
        // Creates an array list for the details of each car
        // 1. Get parking ticket details (can be from command line or file)
        List<User> users = new ArrayList<User>();
        users.add(new User(new CreditCard("1234", "1111222233334444", new Date(2027, 11, 10, 21, 0)), "1234",
                new DriveInTicket("SY65 OED", new Date(2015, 11, 10, 12, 0), false)));
        users.add(new User(new CreditCard("2468", "2222222222222222", new Date(2027, 11, 10, 21, 0)), "2468",
                new PrePaidTicket("SY64 ANF", new Date(2015, 11, 10, 9, 0), true, new Date(2015, 11, 10, 21, 0))));
        users.add(new User(new CreditCard("5678", "5555666677778888", new Date(2027, 11, 10, 21, 0)), "5678",
                new DriveInTicket("AX09 WER", new Date(2015, 11, 10, 15, 0), false)));
        users.add(new User(new CreditCard("2468", "0000999988887777", new Date(2027, 11, 10, 21, 0)), "2468",
                new PrePaidTicket("SW02 DVA", new Date(2015, 11, 10, 6, 0), true, new Date(2015, 11, 10, 8, 0))));

        // Sets a leaving time for each car
        Date timeNow = new Date(2015, 11, 10, 17, 0);
        // Formats the different dates and times
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        DateFormat dateFormatForCreditCard = new SimpleDateFormat("ddMMyyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH, mm");

        // Creates a conditional loop, continue until each ticket has been ran through
        for (User user : users)
        {
            double charge = user.getTicket().calculationCharge(timeNow);
            if (charge == 0)
            {
                System.out.println("PAID ");
                break;
            }
            // == Transaction
            // Increases the transaction number for each ticket
            int transNum = pt.increaseTransNum();

            System.out.println(user.getTicket());
            String userCreditCardPin = user.getPin();
            if (!user.getCreditCard().isValidPin(userCreditCardPin))
            {
                System.err.println("Pin is not valid");
                break;
            }

            Date userCreditCardExpiry = user.getCreditCard().getExpire();
            if (!timeNow.before(userCreditCardExpiry))
            {
                System.err.println("Card is out of date");
                break;
            }

            // CreditCardPayment ccp = pt.checkTicket(user, timeNow, transNum);
            // Writes information to the Authoristation log

            // pt.writeToLogFile("CentralLog.txt",
            // transNum + ", " + pt.ticketInformation(user.getTicket(), dupTran, timeNow, dateFormat, timeFormat));

            // pt.writeToLogFile("AuthorisationLog.txt", transNum + ", " + (user.getTicket().prepaid ? "D" : "O") + ", "
            // + ccp.creditNumber + ", " + dateFormatForCreditCard.format(ccp.toDate));

        }
    }

    private void writeToLogFile(String fileName, String msg)
    {
        // Creates a file writer
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

    public CreditCardPayment checkTicket(User user, Date timeNow, int transNum) throws IOException
    {
        // Sets the display for the console and calls the information to be printed out
        DateFormat dateFormat = new SimpleDateFormat("  dd/MM/yyyy");
        DriveUpParkingTransaction test = new DriveUpParkingTransaction();
        System.out.println("      \tPARKING TICKET\n+------------------------------------------------+");
        System.out.println("  Transaction: " + transNum);
        System.out.println(dateFormat.format(timeNow));
        System.out.println("  Regestration Number: " + user.getTicket().getRegNum());
        CreditCardPayment ccp = test.checkPaid(user.getTicket(), timeNow);
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
