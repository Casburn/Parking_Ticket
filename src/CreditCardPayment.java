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
        SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
        Date testDate = null;
        String date;

        do
        {
            System.out.println("  Enter Credit Card Expiry Date (MM/yyyy): ");
            System.out.print("  > ");
            date = keyboard.next();
            try
            {
                testDate = df.parse(date);
            }
            catch (ParseException e)
            {
                System.out.println("Invalid format");
            }

        }
        while (!df.format(testDate).equals(date));

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
