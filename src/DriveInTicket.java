import java.util.Date;

public class DriveInTicket extends Ticket
{

    public DriveInTicket(String regNum, Date arrivalTime, boolean prepaid)
    {
        this.regNum = regNum;
        this.arrivalTime = arrivalTime;
        this.prepaid = prepaid;
        this.latestLeavingTime = arrivalTime;
    }

    // Sets ticket type to drive in
    // Gets details from parking ticket validator

}
