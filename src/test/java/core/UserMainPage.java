package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMainPage extends HelperBase {

    private static final By GROUPS_BUTTON = By.xpath("//*[contains(@href,'/profile/572081279586/groups')]");

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return isElementPresent(GROUPS_BUTTON);
            }
        });

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(GROUPS_BUTTON));
    }

    public void clickGroups() {
        click(GROUPS_BUTTON);
    }

}
