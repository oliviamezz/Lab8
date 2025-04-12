import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PayCalculator {

    //Calculate the weekly pay
    public static double calculateWeeklyPay(double payRate, double hoursWorked) {
        if (hoursWorked > 40) {
            return (40 * payRate) + ((hoursWorked - 40) * payRate * 1.5);
        } //ends if
        else {
            return hoursWorked * payRate;
        }//ends else
    }//ends calculateWeeklyPay

    public static void main(String[] args) {
        String outputFile = "output.csv";

        try {
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"101", "25.25", "45"});
            data.add(new String[]{"234", "28.5", "50"});
            data.add(new String[]{"342", "30", "40"});
            data.add(new String[]{"767", "24.5", "45"});
            data.add(new String[]{"833", "28.75", "48"});
            data.add(new String[]{"135", "35.5", "40"});
            data.add(new String[]{"674", "40.25", "40"});
            data.add(new String[]{"552", "30.25", "40"});

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            bw.write("EmpID,PayRate,HoursWorked,WeeklyPay");
            bw.newLine();

            for (String[] row : data) {
                String empId = row[0];
                double payRate = Double.parseDouble(row[1]);
                double hoursWorked = Double.parseDouble(row[2]);
                double weeklyPay = calculateWeeklyPay(payRate, hoursWorked);
                String formattedPay = String.format("$%.2f", weeklyPay);

                System.out.println("EmpID: " + empId + ", PayRate: " + payRate +
                        ", HoursWorked: " + hoursWorked + ", WeeklyPay: " + formattedPay);

                String outputLine = empId + "," + payRate + "," + hoursWorked + "," + formattedPay;
                bw.write(outputLine);
                bw.newLine();
            }//ends for loop

            bw.close();
            System.out.println("\nOutput written to output.csv");

        }//ends try
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }//ends catch
    }//ends main method
}//ends Pay Calculator

