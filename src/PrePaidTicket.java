import java.util.Date;

public class PrePaidTicket extends Ticket
{
    public PrePaidTicket(String regNum, Date arrivalTime, boolean prepaid, Date latestLeavingTime)
    {
        // Creates a constructor that calls the information that is needed
        this.regNum = regNum;
        this.arrivalTime = arrivalTime;
        this.prepaid = prepaid;
        this.latestLeavingTime = latestLeavingTime;
    }

    // Sets ticket type to prepaid
    // Gets details from parking ticket validator
}
