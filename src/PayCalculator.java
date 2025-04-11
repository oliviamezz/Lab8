import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PayCalculator {

    //calculate weekly pay + overtime
    public static double calculateWeeklyPay(double payRate, double hoursWorked) {
        if (hoursWorked > 40) {
            return (40 * payRate) + ((hoursWorked - 40) * payRate * 1.5);
        }//ends if
        else {
            return hoursWorked * payRate;
        }//ends else
    }//ends calculate WeeklyPay

    public static void main(String[] args) {
        String inputFile = "pay.csv";      // Input file (to read from)
        String outputFile = "output.csv";  // Output file (to write to)

        try {
            // Sample input data (you'd normally read from a file, but here we simulate it)
            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"EmpID", "PayRate", "HoursWorked"}); // header
            data.add(new String[]{"101", "25.25", "45"});
            data.add(new String[]{"234", "28.5", "50"});
            data.add(new String[]{"342", "30", "40"});
            data.add(new String[]{"767", "24.5", "45"});
            data.add(new String[]{"833", "28.75", "48"});
            data.add(new String[]{"135", "35.5", "40"});
            data.add(new String[]{"674", "40.25", "40"});
            data.add(new String[]{"552", "30.25", "40"});

            //Creates output file
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            bw.write("EmpID,PayRate,HoursWorked,WeeklyPay");
            bw.newLine();

            for (String[] row : data) {
                String empId = row[0];
                double payRate = Double.parseDouble(row[1]);
                double hoursWorked = Double.parseDouble(row[2]);

                //Calculate pay weekly
                double weeklyPay = calculateWeeklyPay(payRate, hoursWorked);

                //Formats +Sets up Symbols
                String formattedPay = String.format("$%.2f", weeklyPay);

                //Creates output
                String outputLine = empId + "," + payRate + "," + hoursWorked + "," + formattedPay;
                bw.write(outputLine);
                bw.newLine();
            }//ends for loop

            //Closes reader
            bw.close();

            System.out.println("Processing complete. See output.csv.");

        }//ends try
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }//ends catch
    }//ends main method
}//ends PayCalculator 


