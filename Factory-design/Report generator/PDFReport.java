// Concrete class for PDF Report
public class PDFReport implements Report {
    private String reportName;
    
    public PDFReport() {
        this.reportName = "Annual_Report";
    }
    
    @Override
    public void generate() {
        System.out.println("\n--- Generating PDF Report ---");
        System.out.println("Step 1: Initializing PDF document...");
        System.out.println("Step 2: Setting page layout and margins...");
        System.out.println("Step 3: Adding header and footer...");
        System.out.println("Step 4: Writing content to PDF...");
        System.out.println("Step 5: Compressing and saving file...");
        System.out.println("Report saved as: " + reportName + getFileExtension());
        System.out.println("PDF Report generated successfully!");
    }
    
    @Override
    public String getReportType() {
        return "PDF";
    }
    
    @Override
    public String getFileExtension() {
        return ".pdf";
    }
}
