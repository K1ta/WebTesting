package tests;

import core.GroupMainPage;
import core.LoginMainPage;
import core.UserMainPage;
import model.TestBot;
import org.junit.Test;

public class GroupTest extends TestBase {

    @Test
    public void testGroup() {
        new LoginMainPage(driver).doLogin(new TestBot("kobalt31@mail.ru", "2017OdnoPassword!#"));
        new UserMainPage(driver).clickGroups();
        GroupMainPage groupMainPage = new GroupMainPage(driver);
        groupMainPage.clickCreateButton();
        groupMainPage.clickPublicPageType();
        groupMainPage.typeGroupName();
        groupMainPage.typeGroupDescription();
        groupMainPage.clickCreateGroup();
    }

}
