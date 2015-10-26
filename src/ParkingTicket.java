import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ParkingTicket
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Transaction: " + transactionNum());

        Ticket theTicket = new Ticket();
        BufferedReader in = new BufferedReader(new FileReader("ParkingTickets.txt"));
        String line;
        while ((line = in.readLine()) != null)
        {
            for (int i = 0; i < 1; ++i)
                in.readLine();
            String lineIWant = in.readLine();
            System.out.println(lineIWant);
        }
        in.close();
    }

    private static int transactionNum()
    {
        Random ran = new Random();
        int number = ran.nextInt(900) + 100;
        return number;
    }
}
