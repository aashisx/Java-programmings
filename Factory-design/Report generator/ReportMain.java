import java.util.Scanner;

// Main class to test the Factory Design Pattern
public class ReportMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportFactory reportFactory = new ReportFactory();
        
        System.out.println("======================================");
        System.out.println("   REPORT GENERATOR FACTORY");
        System.out.println("======================================");
        
        while (true) {
            System.out.println("\nAvailable Report Types:");
            System.out.println("1. PDF   - Portable Document Format (.pdf)");
            System.out.println("2. EXCEL - Microsoft Excel (.xlsx)");
            System.out.println("3. HTML  - Web Page Format (.html)");
            System.out.println("4. EXIT");
            System.out.print("\nEnter report type (PDF/EXCEL/HTML/EXIT): ");
            
            String choice = scanner.nextLine().trim();
            
            if (choice.equalsIgnoreCase("EXIT") || choice.equals("4")) {
                System.out.println("Thank you for using Report Generator!");
                break;
            }
            
            // Use factory to create report
            Report report = reportFactory.createReport(choice);
            
            if (report != null) {
                System.out.println("\n*** Creating " + report.getReportType() + " Report ***");
                report.generate();
                System.out.println("\n--- Report Info ---");
                System.out.println("Type: " + report.getReportType());
                System.out.println("Extension: " + report.getFileExtension());
                System.out.println("-------------------");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
        
        scanner.close();
    }
}
