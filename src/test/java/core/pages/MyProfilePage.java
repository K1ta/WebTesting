package core.pages;

import core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyProfilePage extends HelperBase {

    private static final By SCHOOL_INFO = By.xpath("//*[@class='user-profile_i_value ellip']//div[@class='ellip']//span");

    @Override
    protected void check() {

    }

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getSchool() {
        return driver.findElement(SCHOOL_INFO).getText();
    }
}
