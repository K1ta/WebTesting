package core.pages;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyFriendsPage extends HelperBase {

    private static final String FRIEND_NAME_START = "//*[@class='ucard-v']//*[contains(text(),'";
    private static final String FRIEND_NAME_END = "')]";

    protected MyFriendsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    public UserMainPage clickFriend(String name) {
        By locator = By.xpath(FRIEND_NAME_START + name + FRIEND_NAME_END);
        Assert.assertEquals("Нет друга с таким именем", isElementPresent(locator));
        click(locator);
        return new UserMainPage(driver);
    }
}
