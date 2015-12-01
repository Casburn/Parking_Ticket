import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
                new DriveInTicket("SY65 OED", new Date(2015, 8, 9, 12, 0), false)));
        users.add(new User(new CreditCard("2468", "2222222222222222", new Date(2016, 11, 10, 21, 0)), "2468",
                new PrePaidTicket("SY64 ANF", new Date(2015, 8, 9, 9, 0), true, new Date(2015, 8, 9, 21, 0))));
        users.add(new User(new CreditCard("5678", "5555666677778888", new Date(2036, 11, 10, 21, 0)), "5678",
                new DriveInTicket("AX09 WER", new Date(2015, 8, 9, 15, 0), false)));
        users.add(new User(new CreditCard("2468", "0000999988887777", new Date(2014, 11, 10, 21, 0)), "2468",
                new PrePaidTicket("SW02 DVA", new Date(2015, 8, 9, 6, 0), true, new Date(2015, 8, 9, 8, 0))));

        // Sets a leaving time for each car
        Date timeNow = new Date(2015, 8, 9, 17, 0);
        // Formats the different dates and times
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        DateFormat dateFormatForCreditCard = new SimpleDateFormat("ddMMyyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH, mm");
        DateFormat logTimeFormat = new SimpleDateFormat("ddMMyyyy, HH, mm");

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

            String ccREasonOfFailure = "fail, Card is out of date";
            Date userCreditCardExpiry = user.getCreditCard().getExpire();
            if (timeNow.before(userCreditCardExpiry))
            {
                // payment operation
                ccREasonOfFailure = "pass, N/A";
            }

            pt.writeToLogFile("CentralLog.txt", transNum + ", " + (user.getTicket().toStringShort(logTimeFormat))
                    + ", " + logTimeFormat.format(timeNow) + ", " + user.getTicket().differentHours(timeNow) + ", "
                    + user.getTicket().calculationCharge(timeNow));

            pt.writeToLogFile("AuthorisationLog.txt", transNum + ", " + (user.getTicket().prepaid ? "D" : "O") + ", "
                    + user.getCreditCard() + ", " + dateFormatForCreditCard.format(user.getCreditCard().getExpire())
                    + ", " + dateFormat.format(timeNow) + ", " + ccREasonOfFailure);

            pt.terminalDisplay(user, timeNow);
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

    public void terminalDisplay(User user, Date timeNow)
    {
        NumberFormat GBP = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println("+-----------------------------------------+");
        System.out.println("Transaction Number: " + transactioNumber);
        System.out.println(user.getTicket().toString());
        System.out.println("Length Stayed: " + user.getTicket().differentHours(timeNow) + " hour(s)");
        System.out.println("Amount Due: " + GBP.format(user.getTicket().calculationCharge(timeNow)));
        System.out.println("+-----------------------------------------+\n");
    }

    public int increaseTransNum()
    {
        // Increases the transaction number
        transactioNumber++;
        return transactioNumber;
    }
}
