import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreditCardPayment
{
    public void creditCardDetails()
    {
        Scanner keyboard = new Scanner(System.in);
        String creditNumber;
        SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
        Date testDate = null;
        String date;

        System.out.println("  Enter Credit Card Expiry Date (MM/yyyy): ");
        System.out.print("  >");
        date = keyboard.next();
        try
        {
            testDate = df.parse(date);
        }
        catch (ParseException e)
        {
            System.out.println("Invalid format");
        }
        do
        {
            System.out.println("  Please enter a valid expiry date: ");
            System.out.print("  >");
            date = keyboard.next();
        }
        while (!df.format(testDate).equals(date));

        System.out.println("  Please Enter Credit Card Number: ");
        System.out.print("  >");

        creditNumber = keyboard.next();
        int creditLength = creditNumber.length();

        if (creditLength == 16)
        {

            System.out.println("  CARD ACCECPTED");
        }

        else
        {
            System.out.println("  Please enter a valid credit card number: ");
            System.out.print("  >");
            creditNumber = keyboard.next();
        }
    }
}
