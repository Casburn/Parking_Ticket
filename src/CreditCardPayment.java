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

        System.out.println("  Please Enter Credit Card Number: ");
        System.out.print("  >");

        creditNumber = keyboard.next();
        int creditLength = creditNumber.length();

        if (creditLength == 16)
        {
            System.out.println("  Please Enter Credit Card Expiry (MM/YY): ");
            System.out.print("  >");
            dates = keyboard.nextInt();
            System.out.println("  CARD ACCECPTED");
        }
        else
        {
            System.out.println("  Please enter a valid credit card number: ");
            System.out.print("  >");
            creditNumber = keyboard.next();
        }
    }

    public boolean isThisDateValid(String dateToValidate, String dateFromat)
    {

        if (dateToValidate == null)
        {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try
        {

            // if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        }
        catch (ParseException e)
        {

            e.printStackTrace();
            return false;
        }

        return true;
    }
}
