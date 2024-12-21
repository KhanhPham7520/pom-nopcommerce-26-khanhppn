package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;


public class ExtentTestManager {

    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    private static ExtentReports extent = ExtentReportManager.getExtentReports();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        extentTestMap.remove(Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }
}
