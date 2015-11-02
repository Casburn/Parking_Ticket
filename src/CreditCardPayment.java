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
