package tests;

import core.PersonalDataWrapper;
import core.pages.IAboutPage;
import core.pages.MyAboutPage;
import core.pages.LoginMainPage;
import core.pages.MyMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

public class TestCityOfResidence extends TestBase {

    @Test
    public void saving() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        IAboutPage myAboutPage = myMainPage.clickAbout();
        String expected = "Санкт-Петербург";
        PersonalDataWrapper wrapper = myAboutPage.modifyPersonalData();
        wrapper.setCityOfResidence(expected);
        wrapper.save();
        Assert.assertEquals(expected, myAboutPage.getCityOfResidence());
    }

    @Test
    public void notSaving() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        IAboutPage myAboutPage = myMainPage.clickAbout();
        String expected = myAboutPage.getCityOfResidence();
        PersonalDataWrapper wrapper = myAboutPage.modifyPersonalData();
        wrapper.setCityOfResidence("Ульяновск");
        wrapper.cancel();
        Assert.assertEquals(expected, myAboutPage.getCityOfResidence());
    }
}
