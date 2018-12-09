package core.pages;

import core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserMainPage extends HelperBase {

    private static final By ABOUT = By.xpath("//*[@class='user-profile_lk-o']");

    protected UserMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }


}
