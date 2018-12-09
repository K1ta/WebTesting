package core.pages;

import core.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupMainPage extends HelperBase {

    private static final By LEAVE = By.xpath("//*[@class='u-menu_li  __custom']");
    private static final By LEAVE_PLEASE = By.xpath("//*[@class='button-pro form-actions_yes']");

    protected GroupMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    public void leaveGroup() {
        click(LEAVE);
        click(LEAVE_PLEASE);
    }
}
