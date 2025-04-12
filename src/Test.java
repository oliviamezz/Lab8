//Imports
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println("Testing PayCalculator...\n");

        List<String[]> testData = new ArrayList<>();
        testData.add(new String[]{"101", "25.25", "45"});
        testData.add(new String[]{"234", "28.5", "50"});
        testData.add(new String[]{"342", "30", "40"});
        testData.add(new String[]{"767", "24.5", "45"});

        for (String[] row : testData) {
            String empId = row[0];
            double payRate = Double.parseDouble(row[1]);
            double hoursWorked = Double.parseDouble(row[2]);
            double weeklyPay = PayCalculator.calculateWeeklyPay(payRate, hoursWorked);
            String formattedPay = String.format("$%.2f", weeklyPay);

            //prints output
            System.out.println("EmpID: " + empId + ", PayRate: " + payRate +
                    ", HoursWorked: " + hoursWorked + ", WeeklyPay: " + formattedPay);
        }//ends for loop

        System.out.println("\nTesting complete.");
    }//ends main method
}//ends Test class





