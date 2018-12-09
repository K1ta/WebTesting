package core.pages;

import core.HelperBase;
import model.TestBot;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMainPage extends HelperBase {

    private static final By EMAIL = By.id("field_email");
    private static final By PASSWORD = By.id("field_password");
    private static final By ENTER = By.xpath("//*[@data-l='t,sign_in']");

    public LoginMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Поле ввода email не загрузилось", wait
                .until(driver -> isElementPresent(EMAIL)));

        Assert.assertTrue("Поле ввода пароля не загрузилось", wait
                .until(driver -> isElementPresent(PASSWORD)));

        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));
    }

    public MyMainPage doLogin(TestBot bot) {
        type(bot.getMail(), EMAIL);
        type(bot.getPassword(), PASSWORD);
        click(ENTER);
        return new MyMainPage(driver);
    }
}
