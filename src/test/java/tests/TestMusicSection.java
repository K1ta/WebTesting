package tests;

import core.pages.IAboutPage;
import core.pages.LoginMainPage;
import core.pages.MyMainPage;
import model.TestBot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestMusicSection extends TestBase {

    @Test
    public void testMusicSection() {
        MyMainPage myMainPage = new LoginMainPage(driver).doLogin(TestBot.getDefault());
        myMainPage.clickMore();
        IAboutPage myAboutPage = myMainPage.clickAbout();
        myAboutPage.clearInterestSection("Музыка");
        myAboutPage.typeInterestSection("Музыка", "test1");
        myAboutPage.clickAddInterestSection("Музыка");
        myAboutPage.typeInterestSection("Музыка", "test2");
        myAboutPage.clickAddInterestSection("Музыка");
        List<String> expected = Arrays.asList("test2", "test1");
        List<String> actual = myAboutPage.getInterestSectionList("Музыка");
        Assert.assertEquals(expected, actual);
    }
}
