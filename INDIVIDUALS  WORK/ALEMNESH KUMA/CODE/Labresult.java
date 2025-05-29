import java.util.Date;

public class LabResult {
    private static int counter = 0;
    private String resultId;
    private String testName;
    private String resultValue;
    private Date timestamp;

    public LabResult(String testName, String resultValue) {
        this.resultId = "LR" + (++counter);
        this.testName = testName;
        this.resultValue = resultValue;
        this.timestamp = new Date();
    }

    public String getResultId() { return resultId; }
    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public String getResultValue() { return resultValue; }
    public void setResultValue(String resultValue) { this.resultValue = resultValue; }

    public Date getTimestamp() { return timestamp; }
}
