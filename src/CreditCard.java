import java.util.Date;

public class CreditCard
{
    private String pin;

    private String number;

    private Date expire;

    public CreditCard(String pin, String number, Date expire)
    {
        super();
        this.pin = pin;
        this.number = number;
        this.expire = expire;
    }

    public boolean isValidPin(String pin)
    {
        return this.pin.equalsIgnoreCase(pin);
    }

    public String getNumber()
    {
        return number;
    }

    public Date getExpire()
    {
        return expire;
    }

    @Override
    public String toString()
    {
        return number;
    }
}
