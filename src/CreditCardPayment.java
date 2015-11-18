import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreditCardPayment
{
    String creditNumber;

    Date toDate = new Date();

    public void creditCardDetails()
    {
        Scanner keyboard = new Scanner(System.in);

        String date;

        try
        {
            // Asks for user input of credit card expiry date
            System.out.println("  Enter Valid Credit Card Expiry Date (MM/yyyy): ");
            System.out.print("  > ");
            date = keyboard.next();
            SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
            Date date1 = df.parse(date);
            Date date2 = new Date();
            do
            {
                // Checks expiry date is valid
                if (date1.after(date2))
                {
                    System.out.println("  Valid Expiry Date");
                    break;
                }
                else
                {
                    // If not valid then asks for it again
                    System.out.println("  Please Confirm Credit Card Expiry Date: ");
                    System.out.print("  > ");
                    date = keyboard.next();
                    date1 = df.parse(date);
                }
            }
            while (date1.before(date2));
            toDate = date1;
        }

        catch (ParseException ex)
        {
            ex.printStackTrace();
        }

        do
        {
            // Gets credit card number off of user
            System.out.println("  Please Enter Credit Card Number: ");
            System.out.print("  > ");
            creditNumber = keyboard.next();
        }
        // Makes sure credit card length has 16 numbers
        while (creditNumber.length() != 16);
    }
}
