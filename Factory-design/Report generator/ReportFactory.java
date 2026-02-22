// Factory class to create Report objects
public class ReportFactory {
    
    // Factory method to create reports based on type
    public Report createReport(String reportType) {
        if (reportType == null || reportType.isEmpty()) {
            return null;
        }
        
        switch (reportType.toUpperCase()) {
            case "PDF":
                return new PDFReport();
            case "EXCEL":
                return new ExcelReport();
            case "HTML":
                return new HTMLReport();
            default:
                System.out.println("Unknown report type: " + reportType);
                return null;
        }
    }
}
