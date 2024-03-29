package com.nopcommerce.retryTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTestFailed implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retry test case : " + result.getName() + " with: " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

}
