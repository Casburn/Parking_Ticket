import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Tickets
{
    String regNum;

    String latestLeavingTime, arrivalTime;

    String prepaid;
}

public class Ticket
{
    public static void main(String[] args) throws IOException
    {

        Scanner fin = new Scanner(new FileReader("ParkingTickets" + ".txt"));

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

        /*
         * Tickets five = new Tickets();
         * five.regNum = fin.nextLine();
         * five.arrivalTime = fin.nextLine();
         * five.prepaid = fin.nextLine();
         * five.latestLeavingTime = fin.nextLine();
         */

        fin.close();
        System.out.println("SO");
        System.out.println(one.regNum + "\n " + one.arrivalTime + "\n " + one.prepaid + " \n " + one.latestLeavingTime);
        System.out.println(two.regNum + "\n " + two.arrivalTime + "\n " + two.prepaid + " \n " + two.latestLeavingTime);
        System.out.println(three.regNum + "\n " + three.arrivalTime + "\n " + three.prepaid + " \n "
                + three.latestLeavingTime);
        System.out.println(four.regNum + "\n " + four.arrivalTime + "\n " + four.prepaid + " \n "
                + four.latestLeavingTime);
        /*
         * System.out.println(five.regNum + "\n " + five.arrivalTime + "\n " + five.prepaid + "  " +
         * five.latestLeavingTime);
         */
    }
}
