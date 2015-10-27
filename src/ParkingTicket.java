import java.util.Random;

public class ParkingTicket
{
    public static void main(String[] args)
    {
        System.out.println("Transaction: " + transactionNum());
    }

    private static int transactionNum()
    {
        Random ran = new Random();
        int number = ran.nextInt(900) + 100;
        return number;
    }
}
