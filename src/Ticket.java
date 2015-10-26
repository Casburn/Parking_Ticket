import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Tickets
{
    String regNum;

    String latestLeavingTime;

    String arrivalTime;

    String prepaid;
}

public class Ticket
{

    public void main(String[] args) throws IOException
    {
        TheTicket();
    }

    public void TheTicket() throws IOException
    {
        Scanner fin = new Scanner(new FileReader("ParkingTickets" + ".txt"));
        BufferedReader in = new BufferedReader(new FileReader("ParkingTickets.txt"));
        String line;
        while ((line = in.readLine()) != null)
        {
            System.out.println(line);
        }
        in.close();

        Tickets one = new Tickets();
        one.regNum = fin.nextLine();
        one.arrivalTime = fin.nextLine();
        one.prepaid = fin.nextLine();
        one.latestLeavingTime = fin.nextLine();

        Tickets two = new Tickets();
        two.regNum = fin.nextLine();
        two.arrivalTime = fin.nextLine();
        two.prepaid = fin.nextLine();
        two.latestLeavingTime = fin.nextLine();

        Tickets three = new Tickets();
        three.regNum = fin.nextLine();
        three.arrivalTime = fin.nextLine();
        three.prepaid = fin.nextLine();
        three.latestLeavingTime = fin.nextLine();

        Tickets four = new Tickets();
        four.regNum = fin.nextLine();
        four.arrivalTime = fin.nextLine();
        four.prepaid = fin.nextLine();
        four.latestLeavingTime = fin.nextLine();

        fin.close();

        System.out.println(" PARKING TICKET\n+--------------+\n " + one.regNum + "\n " + one.arrivalTime + "\n "
                + one.prepaid + " \n " + one.latestLeavingTime + "\n");
        System.out.println(" PARKING TICKET\n+--------------+\n " + two.regNum + "\n " + two.arrivalTime + "\n "
                + two.prepaid + " \n " + two.latestLeavingTime + "\n");
        System.out.println(" PARKING TICKET\n+--------------+\n " + three.regNum + "\n " + three.arrivalTime + "\n "
                + three.prepaid + " \n " + three.latestLeavingTime + "\n");
        System.out.println(" PARKING TICKET\n+--------------+\n " + four.regNum + "\n " + four.arrivalTime + "\n "
                + four.prepaid + " \n " + four.latestLeavingTime);
    }
}
