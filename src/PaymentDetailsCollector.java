import java.util.Date;

//Get details from User 
public class PaymentDetailsCollector
{
    Date paymentDate;

    double creditCardNumber;

    // Get the entered payment details
    public Date getPaymentDate()
    {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate)
    {
        this.paymentDate = paymentDate;
    }

    public double getCreditCardNumber()
    {
        return creditCardNumber;
    }

    public void setCreditCardNumber(double creditCardNumber)
    {
        this.creditCardNumber = creditCardNumber;
    }

    /*
     * try
     * {
     * // Asks for user input of credit card expiry date
     * System.out.println("  Enter Valid Credit Card Expiry Date (MM/yyyy): ");
     * System.out.print("  > ");
     * date = keyboard.next();
     * SimpleDateFormat df = new SimpleDateFormat("MM/yyyy");
     * Date date1 = df.parse(date);
     * Date date2 = new Date();
     * do
     * {
     * // Checks expiry date is valid
     * if (date1.after(date2))
     * {
     * System.out.println("  Valid Expiry Date");
     * break;
     * }
     * else
     * {
     * // If not valid then asks for it again
     * System.out.println("  Please Confirm Credit Card Expiry Date: ");
     * System.out.print("  > ");
     * date = keyboard.next();
     * date1 = df.parse(date);
     * }
     * }
     * while (date1.before(date2));
     * toDate = date1;
     * }
     * 
     * catch (ParseException ex)
     * {
     * ex.printStackTrace();
     * }
     * 
     * do
     * {
     * // Gets credit card number off of user
     * System.out.println("  Please Enter Credit Card Number: ");
     * System.out.print("  > ");
     * creditNumber = keyboard.next();
     * }
     * // Makes sure credit card length has 16 numbers
     * while (creditNumber.length() != 16);
     * }
     */
}
