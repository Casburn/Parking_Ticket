import java.util.Date;

public class DriveInTicket extends ParkingTicketFactory
{

    public DriveInTicket(String regNum, Date arrivalTime, boolean prepaid)
    {
        super(regNum, arrivalTime, prepaid);
    }

    public DriveInTicket(String regNum, Date arrivalTime, boolean prepaid, Date latestLeavingTime)
    {
        super(regNum, arrivalTime, prepaid, latestLeavingTime);
    }
    // Sets ticket type to drive in
    // Gets details from parking ticket validator

}
