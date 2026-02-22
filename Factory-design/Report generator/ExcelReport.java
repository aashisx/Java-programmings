// Concrete class for Excel Report
public class ExcelReport implements Report {
    private String reportName;
    
    public ExcelReport() {
        this.reportName = "Data_Report";
    }
    
    @Override
    public void generate() {
        System.out.println("\n--- Generating Excel Report ---");
        System.out.println("Step 1: Creating new workbook...");
        System.out.println("Step 2: Adding worksheets...");
        System.out.println("Step 3: Formatting cells and columns...");
        System.out.println("Step 4: Populating data into cells...");
        System.out.println("Step 5: Applying formulas and charts...");
        System.out.println("Report saved as: " + reportName + getFileExtension());
        System.out.println("Excel Report generated successfully!");
    }
    
    @Override
    public String getReportType() {
        return "EXCEL";
    }
    
    @Override
    public String getFileExtension() {
        return ".xlsx";
    }
}
