import java.util.Date;

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

}
