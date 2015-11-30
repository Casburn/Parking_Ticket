public class User
{
    private CreditCard card;

    private String pin;

    private Ticket ticket;

    public User(CreditCard card, String pin, Ticket ticket)
    {
        this.card = card;
        this.pin = pin;
        this.ticket = ticket;
    }

    public CreditCard getCreditCard()
    {
        return card;
    }

    public String getPin()
    {
        return pin;
    }

    public Ticket getTicket()
    {
        return ticket;
    }

}
