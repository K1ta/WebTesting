package tests;

import core.PersonalDataWrapper;
import core.pages.IAboutPage;
import core.pages.LoginMainPage;
import core.pages.MyAboutPage;
import core.pages.MyMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestBirthdate extends TestBase {

    @Test
    public void positive() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        IAboutPage myAboutPage = myMainPage.clickAbout();
        PersonalDataWrapper personalData = myAboutPage.modifyPersonalData();
        personalData.setBirthDay(31);
        personalData.setBirthMonth(8);
        personalData.setBirthYear(1998);
        personalData.save();
        String expected = "31 августа 1998 (20 лет)";
        Assert.assertEquals(expected, myAboutPage.getBirthdate());
    }

    @Test
    public void illegalDay() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        IAboutPage myAboutPage = myMainPage.clickAbout();
        PersonalDataWrapper personalData = myAboutPage.modifyPersonalData();
        personalData.setBirthDay(31);
        personalData.setBirthMonth(9);
        personalData.setBirthYear(1998);
        personalData.save();
        Assert.assertTrue(personalData.error());
    }
}
