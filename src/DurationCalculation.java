import java.util.Date;

public class DurationCalculation
{
    // Calcutlates length of stay
    // Gets details from transaction manager
    public long differentHours(Date timeNow)
    {
        // Does calculations to set the time stayed at car park
        long diffHours = (timeNow.getTime() - latestLeavingTime.getTime()) / (60 * 60 * 1000);
        // Returns the time stayed
        return diffHours;
    }
}
