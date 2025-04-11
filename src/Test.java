//imports lists and arrays
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        // Sample data to test
        List<String[]> testData = new ArrayList<>();
        testData.add(new String[]{"101", "25.25", "45"});
        testData.add(new String[]{"234", "28.5", "50"});
        testData.add(new String[]{"342", "30", "40"});
        testData.add(new String[]{"767", "24.5", "45"});
        //loop through
        for (String[] row : testData) {
            String empId = row[0];
            double payRate = Double.parseDouble(row[1]);
            double hoursWorked = Double.parseDouble(row[2]);


            double weeklyPay = PayCalculator.calculateWeeklyPay(payRate, hoursWorked);

            // Format weekly pay and print it
            String formattedPay = String.format("$%.2f", weeklyPay);
            System.out.println("EmpID: " + empId + ", Weekly Pay: " + formattedPay);
        }//ends loop

    }//ends main method
}//ends Test class





