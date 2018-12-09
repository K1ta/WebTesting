package tests;

import core.pages.MyAboutPage;
import core.pages.LoginMainPage;
import core.pages.MyMainPage;
import core.pages.MyProfilePage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class TestAddSchool extends TestBase {

    @Test
    public void testAddSchool() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        MyAboutPage myAboutPage = myMainPage.clickAbout();
        String expected = "2 школа";
        myAboutPage.addSchool(expected);
        MyProfilePage profilePage = myAboutPage.clickProfile();
        String actual = profilePage.getSchool();
        Assert.assertEquals(expected, actual);
    }
}
