import java.io.FileReader;
import java.util.Scanner;

class ParkTick
{
    String regNum;

    String arrivalTime;

    String prepaid;

    String latestLeavingTime;

    public static class ParkingTicket
    {
        public static void main(String[] args) throws Exception
        {
            int numberOfTickets = 5;
            Tickets[] tickets = new Tickets[numberOfTickets];

            Scanner fin = new Scanner(new FileReader("ParkingTickets.txt"));

            for (int i = 0; i < numberOfTickets; i++)
            {
                tickets[i] = new Tickets();
                tickets[i].regNum = fin.nextLine();
                tickets[i].arrivalTime = fin.nextLine();
                tickets[i].prepaid = fin.nextLine();
                tickets[i].latestLeavingTime = fin.nextLine();
            }

            fin.close();

            for (int i = 0; i < numberOfTickets; i++)
            {
                System.out.println((i + 1) + ". " + tickets[i]);
            }
        }
    }

    public String toString()
    {
        return (this.regNum + "\n" + this.arrivalTime + "\n" + this.prepaid + "\n" + this.latestLeavingTime);
    }
}
