package kainos.specs.listener;

import kainos.specs.accessibility.AccessibilityService;
import kainos.specs.environment.Environment;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class EventListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("onTestStart!!!!" + result.getMethod().getMethodName() + ": " + Arrays.stream(result.getParameters()).map(Object::toString).collect(Collectors.joining()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("onTestSuccess!!!!" + result.getMethod().getMethodName() + ": " + Arrays.stream(result.getParameters()).map(Object::toString).collect(Collectors.joining()));
        if(Environment.failOnAccessibilityFailure() && AccessibilityService.getInstance().accessibilityCheckFailed()) {
            result.setStatus(ITestResult.FAILURE);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("onTestFailure!!!!" + result.getMethod().getMethodName() + ": " + Arrays.stream(result.getParameters()).map(Object::toString).collect(Collectors.joining()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("onTestSkipped!!!!" + result.getMethod().getMethodName() + ": " + Arrays.stream(result.getParameters()).map(Object::toString).collect(Collectors.joining()));
        log.warn("TEST SKIPPED!!!");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("onTestFailedButWithinSuccessPercentage!!!!" + result.getMethod().getMethodName() + ": " + Arrays.stream(result.getParameters()).map(Object::toString).collect(Collectors.joining()));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("onStart!!!!" + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("onFinish!!!!" + iTestContext.getName());
    }

}
