public class DriveUpParkingTransaction
{
    public void checkPaid(Ticket tickets)
    {
        if (tickets.prepaid)
        {
            System.out.println("  Ticket Type: Pre-Paid");
        }
        else
        {
            System.out.println("  Ticket Type: Drive In");
            System.out.println("  Length of time stayed: " + tickets.driveInLeaveTime() + " hour(s)");
            pricing(tickets);
        }
    }

    public void pricing(Ticket tickets)
    {
        if (tickets.driveInLeaveTime() <= 1)
        {
            System.out.println("  Cost: £4.70");
        }
        else if (tickets.driveInLeaveTime() > 1 && tickets.driveInLeaveTime() <= 2)
        {
            System.out.println("  Cost: £7.40");
        }
        else if (tickets.driveInLeaveTime() > 2 && tickets.driveInLeaveTime() <= 4)
        {
            System.out.println("  Cost: £10.30");
        }
        else if (tickets.driveInLeaveTime() >= 5 && tickets.driveInLeaveTime() <= 6)
        {
            System.out.println("  Cost: £14.80");
        }
        else if (tickets.driveInLeaveTime() >= 7 && tickets.driveInLeaveTime() <= 9)
        {
            System.out.println("  Cost: £17.80");
        }
        else if (tickets.driveInLeaveTime() >= 8 && tickets.driveInLeaveTime() <= 12)
        {
            System.out.println("  Cost: £20.20");
        }
        else if (tickets.driveInLeaveTime() >= 13 && tickets.driveInLeaveTime() <= 24)
        {
            System.out.println("  Cost: £23.70");
        }
        else
        {
            System.out.println("Your car is being taken and sold");
        }
    }
}
// PrePaidParkingTransaction prepaidTicket = new PrePaidParkingTransaction();
