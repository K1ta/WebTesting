package core.pages;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProfilePage extends HelperBase {

    private static final By SCHOOL_INFO = By.xpath("//*[@class='user-profile_i_value ellip']//div[@class='ellip']//span");

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Информация о школе не загрузилась", wait
                .until(driver -> isElementPresent(SCHOOL_INFO)));

        wait.until(ExpectedConditions.visibilityOfElementLocated(SCHOOL_INFO));
    }

    public String getSchool() {
        return driver.findElement(SCHOOL_INFO).getText();
    }
}
