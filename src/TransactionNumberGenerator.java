public class TransactionNumberGenerator
{
    // generates random transaction number
    // TO-DO - Might need to be changed as this could print out 1 on each rotation or take int transaction nuber = 0 out
    // and put else where?

    public int increaseTransNum()
    {
        int transactionNumber = 0;
        transactionNumber++;
        return transactionNumber;
    }
}
