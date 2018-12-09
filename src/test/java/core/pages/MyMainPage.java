package core.pages;

import core.HelperBase;
import core.MyAboutPageFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyMainPage extends HelperBase {

    private static final By GROUPS_BUTTON = By.xpath("//*[@data-l='t,userAltGroup']");
    private static final By MORE_BUTTON = By.xpath("//*[@data-l='t,toggler']");
    private static final By ABOUT_BUTTON = By.xpath("//*[@data-l='t,userProfile']");

    public MyMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        Assert.assertTrue("Кнопка 'Группы' не загрузилась", wait
                .until(driver -> isElementPresent(GROUPS_BUTTON)));

        Assert.assertTrue("Кнопка 'Еще' не загрузилась", wait
                .until(driver -> isElementPresent(MORE_BUTTON)));

        Assert.assertTrue("Кнопка 'О себе' не загрузилась", wait
                .until(driver -> isElementPresent(ABOUT_BUTTON)));
    }

    public MyGroupMainPage clickGroups() {
        click(GROUPS_BUTTON);
        return new MyGroupMainPage(driver);
    }

    public void clickMore() {
        click(MORE_BUTTON);
    }

    public IAboutPage clickAbout() {
        click(ABOUT_BUTTON);
        return MyAboutPageFactory.get(driver);
    }

}
