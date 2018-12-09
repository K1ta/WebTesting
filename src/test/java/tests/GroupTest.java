package tests;

import core.pages.MyGroupMainPage;
import core.pages.LoginMainPage;
import core.pages.MyMainPage;
import model.TestBot;
import org.junit.Ignore;
import org.junit.Test;

public class GroupTest extends TestBase {

    @Ignore
    @Test
    public void testGroup() {
        new LoginMainPage(driver).doLogin(new TestBot("kobalt31@mail.ru", "2017OdnoPassword!#"));
        new MyMainPage(driver).clickGroups();
        MyGroupMainPage myGroupMainPage = new MyGroupMainPage(driver);
        myGroupMainPage.clickCreateButton();
        myGroupMainPage.clickPublicPageType();
        myGroupMainPage.typeGroupName();
        myGroupMainPage.typeGroupDescription();
        myGroupMainPage.clickCreateGroup();
    }

}
