package tests;

import core.PersonalDataWrapper;
import core.pages.IAboutPage;
import core.pages.LoginMainPage;
import core.pages.MyAboutPage;
import core.pages.MyMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class TestName extends TestBase {

    @Test
    public void positive() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        IAboutPage myAboutPage = myMainPage.clickAbout();
        PersonalDataWrapper personalData = myAboutPage.modifyPersonalData();
        String expectedName = "Никита";
        String expectedSurname = "Кузьмин";
        personalData.setName(expectedName);
        personalData.setSurname(expectedSurname);
        personalData.save();
        String expected = expectedName + " " + expectedSurname;
        Assert.assertEquals(expected, myAboutPage.getFullName());
    }

    @Test
    public void illegalSymbols() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        IAboutPage myAboutPage = myMainPage.clickAbout();
        PersonalDataWrapper personalData = myAboutPage.modifyPersonalData();
        personalData.setName(">");
        personalData.save();
        Assert.assertTrue(personalData.error());
    }
}
