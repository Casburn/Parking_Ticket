import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingTicket
{
    private int transactioNumber = 0;

    public int getTransactioNumber()
    {
        return transactioNumber;
    }

    private Date timeNow;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException
    {
        ParkingTicket pt = new ParkingTicket();
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

        pt.setTimeNow(new Date(2015, 8, 9, 17, 0));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        DateFormat dateFormatForCreditCard = new SimpleDateFormat("ddMMyyyy");
        DateFormat logTimeFormat = new SimpleDateFormat("ddMMyy, HH, mm");
        NumberFormat GBPNum = NumberFormat.getInstance();

        for (User user : users)
        {
            double charge = user.getTicket().calculationCharge(pt.getTimeNow());
            if (charge == 0)
            {
                System.out.println("PAID ");
                break;
            }
            // == Transaction
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
            if (pt.getTimeNow().before(userCreditCardExpiry))
            {
                // payment operation
                ccREasonOfFailure = "pass, N/A";
            }
            System.out.println(user.getTicket().print(pt));

            pt.writeToLogFile(
                    "CentralLog.txt",
                    transNum + ", " + (user.getTicket().toStringShort(logTimeFormat)) + ", "
                            + logTimeFormat.format(pt.getTimeNow()) + ", "
                            + user.getTicket().diffInHours(pt.getTimeNow()) + ", "
                            + GBPNum.format(user.getTicket().calculationCharge(pt.getTimeNow())));

            pt.writeToLogFile(
                    "AuthorisationLog.txt",
                    transNum + ", " + (user.getTicket().isPrepaid() ? "D" : "O") + ", " + user.getCreditCard() + ", "
                            + dateFormatForCreditCard.format(user.getCreditCard().getExpire()) + ", "
                            + dateFormat.format(pt.getTimeNow()) + ", " + ccREasonOfFailure);
        }
    }

    public Date getTimeNow()
    {
        return timeNow;
    }

    private void setTimeNow(Date timeNow)
    {
        this.timeNow = timeNow;
    }

    private void writeToLogFile(String fileName, String msg)
    {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try
        {
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

    public int increaseTransNum()
    {
        transactioNumber++;
        return transactioNumber;
    }
}
