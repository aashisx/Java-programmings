// Concrete class for HTML Report
public class HTMLReport implements Report {
    private String reportName;
    
    public HTMLReport() {
        this.reportName = "Web_Report";
    }
    
    @Override
    public void generate() {
        System.out.println("\n--- Generating HTML Report ---");
        System.out.println("Step 1: Creating HTML document structure...");
        System.out.println("Step 2: Adding CSS styles...");
        System.out.println("Step 3: Building table elements...");
        System.out.println("Step 4: Inserting data into HTML...");
        System.out.println("Step 5: Validating and saving file...");
        System.out.println("Report saved as: " + reportName + getFileExtension());
        System.out.println("HTML Report generated successfully!");
    }
    
    @Override
    public String getReportType() {
        return "HTML";
    }
    
    @Override
    public String getFileExtension() {
        return ".html";
    }
}
