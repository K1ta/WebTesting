package core;

import core.pages.IAboutPage;
import core.pages.MyAboutPage;
import core.pages.NewMyAboutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MyAboutPageFactory {

    private final static By MUSIC_SECTION = By.xpath("//*[@class='portlet_h2']//span[contains(text(), 'Музыка')]");

    public static IAboutPage get(WebDriver driver) {
        if (isMusicSectionPresent(driver)) {
            return new MyAboutPage(driver);
        }
        return new NewMyAboutPage(driver);
    }

    private static boolean isMusicSectionPresent(WebDriver driver) {
        // find element
        try {
            driver.findElement(MUSIC_SECTION);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
