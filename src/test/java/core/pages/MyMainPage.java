package core.pages;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyMainPage extends HelperBase {

    private static final By GROUPS_BUTTON = By.xpath("//*[@data-l='t,userAltGroup']");
    private static final By MORE_BUTTON = By.xpath("//*[@data-l='t,toggler']");
    private static final By ABOUT_BUTTON = By.xpath("//*[@data-l='t,userProfile']");
    private static final By FRIENDS_BUTTON = By.xpath("//*[@data-l='t,userFriend']");

    public MyMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Кнопка 'Группы' не загрузилась", new WebDriverWait(driver, WAIT_TIME)
                .until((ExpectedCondition<Boolean>) driver -> isElementPresent(GROUPS_BUTTON)));

        Assert.assertTrue("Кнопка 'Еще' не загрузилась", new WebDriverWait(driver, WAIT_TIME)
                .until((ExpectedCondition<Boolean>) driver -> isElementPresent(MORE_BUTTON)));

        Assert.assertTrue("Кнопка 'О себе' не загрузилась", new WebDriverWait(driver, WAIT_TIME)
                .until((ExpectedCondition<Boolean>) driver -> isElementPresent(ABOUT_BUTTON)));

        Assert.assertTrue("Кнопка 'Друзья' не загрузилась", new WebDriverWait(driver, WAIT_TIME)
                .until((ExpectedCondition<Boolean>) driver -> isElementPresent(FRIENDS_BUTTON)));
    }

    public MyGroupMainPage clickGroups() {
        click(GROUPS_BUTTON);
        return new MyGroupMainPage(driver);
    }

    public void clickMore() {
        click(MORE_BUTTON);
    }

    public MyAboutPage clickAbout() {
        click(ABOUT_BUTTON);
        return new MyAboutPage(driver);
    }

    public MyFriendsPage clickFriends() {
        click(FRIENDS_BUTTON);
        return new MyFriendsPage(driver);
    }

}
