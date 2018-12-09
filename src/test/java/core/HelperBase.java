package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class HelperBase {
    protected WebDriver driver;
    protected long WAIT_TIME = 5;
    private boolean acceptNextAlert = true;
    private Actions actions;

    protected HelperBase(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        check();
    }

    protected abstract void check();

    protected void type(String text, By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isDisplayed()) {
            actions.moveToElement(element);
        }
        new WebDriverWait(driver, WAIT_TIME)
                .until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
        element.sendKeys(text);
    }

    protected void click(By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isDisplayed()) {
            actions.moveToElement(element);
        }
        new WebDriverWait(driver, WAIT_TIME)
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected List<WebElement> get(By locator) {
        return driver.findElements(locator);
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
