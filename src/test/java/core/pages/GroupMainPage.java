package core.pages;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupMainPage extends HelperBase {

    private static final By LEAVE = By.xpath("//*[@class='u-menu_li  __custom']");
    private static final By LEAVE_PLEASE = By.xpath("//*[@class='button-pro form-actions_yes']");

    protected GroupMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {
        Assert.assertTrue("Кнопка 'Покинуть группу' не загрузилась", wait
                .until(driver -> isElementPresent(LEAVE)));

        wait.until(ExpectedConditions.visibilityOfElementLocated(LEAVE));
    }

    public void leaveGroup() {
        click(LEAVE);
        click(LEAVE_PLEASE);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(LEAVE_PLEASE)));
    }
}
