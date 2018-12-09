package core.pages;

import core.HelperBase;
import core.PersonalDataWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MyAboutPage extends HelperBase {

    private static final By PROFILE = By.xpath("//*[@class='compact-profile']");
    private static final By HOMETOWN = By.xpath("//*[@class='user-profile_i'][2]//*[@data-type='TEXT']");
    private static final By CITY_OF_RESIDENCE = By.xpath("//*[@class='user-profile_i'][3]//*[@data-type='TEXT']");
    private static final By MODIFY_DATA = By.xpath("(//*[@class='user-profile_lk-o'])[1]");
    private static final By BIRTHDATE = By.xpath("//*[@class='user-profile_i_value' and @data-type='AGE']");
    private static final By FULL_NAME = By.xpath("//*[@class='compact-profile_a ellip-i']");
    private static final By ADD_WORK = By.xpath("(//*[@class='user-profile_lk-o'])[2]");
    private static final By ADD_SCHOOL = By.xpath("(//*[@class='user-profile_lk-o'])[3]");
    private static final By ADD_ARMY = By.xpath("(//*[@class='user-profile_lk-o'])[4]");

    private static final By SCHOOL_INPUT = By.xpath("//*[@id='st.layer.schoolText']");
    private static final By SCHOOL_ELEMENT = By.xpath("//*[@class='sug_it-div']");
    private static final By SCHOOL_CLOSE = By.xpath("//*[@id='nohook_modal_close']");
    private static final By JOIN = By.xpath("//*[@name='button_join']");

    private static final String INTEREST_SECTION_INPUT = "//*[@name='st.nin']";
    private static final String INTEREST_SECTION_ADD = "//*[contains(@name,'btnSubmit')]";
    private static final String INTEREST_SECTION_ELEMENT = "//span[contains(@class,'interests_li_info')]";
    private static final String INTEREST_SECTION_DELETE = "//*[contains(@class, 'interests_li_ctrls')]";
    private static final String INTEREST_SECTION_START = "//span[contains(@class, 'portlet_h2_tx') and (text()='";
    private static final String INTEREST_SECTION_END = "')]/parent::div/following-sibling::div[1]";
    private static final String SCHOOL_START = "//*[contains(@title,'";
    private static final String SCHOOL_END = "')]/parent::a";

    public MyAboutPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {

    }

    public void addSchoold(String school) {
        By locator = By.xpath(SCHOOL_START + school + SCHOOL_END);
        if (isElementPresent(locator)) {
            click(locator);
            GroupMainPage groupMainPage = new GroupMainPage(driver);
            groupMainPage.leaveGroup();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.navigate().back();
        }
        click(ADD_SCHOOL);
        type(school, SCHOOL_INPUT);
        click(SCHOOL_ELEMENT);
        click(JOIN);
        if (isElementPresent(SCHOOL_CLOSE)) {
            click(SCHOOL_CLOSE);
        }
    }

    public String getCityOfResidence() {
        return driver.findElement(CITY_OF_RESIDENCE).getText();
    }

    public String getHometown() {
        return driver.findElement(HOMETOWN).getText();
    }

    public String getBirthdate() {
        return driver.findElement(BIRTHDATE).getText();
    }

    public String getFullName() {
        return driver.findElement(FULL_NAME).getText();
    }

    public void typeInterestSection(String section, String text) {
        By locator = By.xpath(INTEREST_SECTION_START + section + INTEREST_SECTION_END + INTEREST_SECTION_INPUT);
        type(text, locator);
    }

    public void clickAddInterestSection(String section) {
        By locator = By.xpath(INTEREST_SECTION_START + section + INTEREST_SECTION_END + INTEREST_SECTION_ADD);
        click(locator);
        new WebDriverWait(driver, 5).until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
    }

    public void clearInterestSection(String section) {
        By locator = By.xpath(INTEREST_SECTION_START + section + INTEREST_SECTION_END + INTEREST_SECTION_DELETE);
        while (isElementPresent(locator)) {
            click(locator);
            new WebDriverWait(driver, 5).until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
        }
    }

    public List<String> getInterestSectionList(String section) {
        By locator = By.xpath(INTEREST_SECTION_START + section + INTEREST_SECTION_END + INTEREST_SECTION_ELEMENT);
        List<WebElement> elements = get(locator);
        List<String> interests = new ArrayList<>();
        for (WebElement element : elements) {
            interests.add(element.getText());
        }
        return interests;
    }

    public PersonalDataWrapper modifyPersonalData() {
        click(MODIFY_DATA);
        return new PersonalDataWrapper(driver);
    }

    public MyProfilePage clickProfile() {
        click(PROFILE);
        return new MyProfilePage(driver);
    }

}
