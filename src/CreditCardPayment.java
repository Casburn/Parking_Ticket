import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreditCardPayment
{

    private static final int creditLength = 16;

    public void creditCardDetails()
    {
        Scanner keyboard = new Scanner(System.in);
        String creditNumber;

        DateFormat dateFormat = new SimpleDateFormat("  MM/yyyy");
        Date toDate = new Date();

        Date testDate = null;
        String date;

        try
        {
            System.out.println("  Enter Credit Card Expiry Date (MM/yyyy): ");
            System.out.print("  > ");
            date = keyboard.next();

            SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
            Date date1 = df.parse(date);
            Date date2 = toDate;

            do
            {
                if (date1.after(date2))
                {
                    System.out.println("  Valid Expiry Date");
                }
                else
                {
                    System.out.println("  Invalid Expiry Date");
                    System.out.println("  Enter Valid Credit Card Expiry Date (MM/yyyy): ");
                    System.out.print("  > ");
                    date = keyboard.next();
                }
            }
            while (date1.before(date2));

        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }

        do
        {
            // int creditLength = creditNumber.length();
            System.out.println("  Please Enter Credit Card Number: ");
            System.out.print("  > ");
            creditNumber = keyboard.next();
        }

        while (creditLength != 16);

    }
}
