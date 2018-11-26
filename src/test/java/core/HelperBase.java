package core;

import org.openqa.selenium.*;

abstract class HelperBase {
    WebDriver driver;
    private boolean acceptNextAlert = true;

    HelperBase(WebDriver driver) {
        this.driver = driver;
        check();
    }

    protected abstract void check();

    void type(String name, By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(name);
    }

    void click(By locator) {
        driver.findElement(locator).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
