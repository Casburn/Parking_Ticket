import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingTicketFactory
{
    // Creates parking ticket type - pre paid drive in
    // Gets parking ticket details

    String regNum;

    Date arrivalTime;

    boolean prepaid;

    Date latestLeavingTime;

    double lengthOfTime;

    public void createParkingTickets()
    {
        List<ParkingTicketFactory> tickets = new ArrayList<ParkingTicketFactory>();
        tickets.add(new ParkingTicketFactory("SY65 OED", new Date(2015, 11, 10, 12, 0), false));
        tickets.add(new ParkingTicketFactory("SY64 ANF", new Date(2015, 11, 10, 9, 0), true, new Date(2015, 11, 10, 21,
                0)));
        tickets.add(new ParkingTicketFactory("AX09 WER", new Date(2015, 11, 10, 15, 0), false));
        tickets.add(new ParkingTicketFactory("SW02 DVA", new Date(2015, 11, 10, 6, 0), true, new Date(2015, 11, 10, 8,
                0)));
    }

    public ParkingTicketFactory(String regNum, Date arrivalTime, boolean prepaid, Date latestLeavingTime)
    {
        // Creates a constructor that calls the information that is needed
        this.regNum = regNum;
        this.arrivalTime = arrivalTime;
        this.prepaid = prepaid;
        this.latestLeavingTime = latestLeavingTime;
    }

    public ParkingTicketFactory(String regNum, Date arrivalTime, boolean prepaid)
    {
        this.regNum = regNum;
        this.arrivalTime = arrivalTime;
        this.prepaid = prepaid;
        this.latestLeavingTime = arrivalTime;
    }

    public String getRegNum()
    {
        // Returns the registration number
        return regNum;
    }
}
