package tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OldTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    private String mail = "kobalt31@mail.ru";
    private String password = "2017OdnoPassword!#";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/home/nikita/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=~/.config/chromium/Default");
        //options.addArguments("--start-maximized");
        //options.setExperimentalOption("excludeSwitches", "disable-sync");
        //options.addArguments("--disable-sync");
        //options.addArguments("--enable-sync");
        driver = new ChromeDriver();
        //driver = new ChromeDriver();

        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /*@Test
    public void testKatalon() throws Exception {
        driver.get("https://www.google.ru/search?q=katalon&oq=katalon&aqs=chrome.0.69i59j69i60l2j69i59l2j69i60.1706j0j7&sourceid=chrome&ie=UTF-8");
        driver.findElement(By.xpath("//a[contains(@href, 'https://www.katalon.com/')]")).click();
        driver.findElement(By.xpath("//a[@href='http://forum.katalon.com/']"));
    }*/

    /*@Test
    public void testCaseWithGroup() throws Exception {
        driver.get("https://ok.ru/feed");
        doLogin();
        clickGroups();
        createNewGroup();
        fillName();
        fillDescription();
        driver.findElement(By.id("hook_FormButton_button_create")).click();
    }

    private void doLogin() throws Exception {
        driver.findElement(By.id("field_email")).clear();
        driver.findElement(By.id("field_email")).sendKeys(mail);
        driver.findElement(By.id("field_password")).clear();
        driver.findElement(By.id("field_password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"anonymPageContent\"]/div[2]/div/div[2]/form/div[5]/div[1]/input")).click();
    }

    private void clickGroups() {
        driver.findElement(By.linkText("Группы")).click();
    }

    private void createNewGroup() {
        driver.findElement(By.xpath("//*[contains(@href,'/profile/572081279586/groups')]")).click();
        driver.findElement(By.xpath("//*[@id=\"hook_Block_CreateGroupBlock\"]/div/a")).click();
        driver.findElement(By.xpath("//*[contains(@data-l,'t,PAGE')]")).click();
    }

    private void fillName() {
        driver.findElement(By.id("field_name")).click();
        driver.findElement(By.id("field_name")).clear();
        driver.findElement(By.id("field_name")).sendKeys("Test");
    }

    private void fillDescription() {
        driver.findElement(By.id("field_description")).click();
        driver.findElement(By.id("field_description")).clear();
        driver.findElement(By.id("field_description")).sendKeys("Test");
    }

    @Test
    public void testVK() throws Exception {
        driver.get("https://vk.com/im");
        driver.findElement(By.xpath("//li[@id='l_pr']/a/span/span[3]")).click();
        driver.findElement(By.xpath("//div[@id='profile_audios']/a/div/span[2]")).click();
    }

    @Test
    public void testOK() throws Exception {
        driver.get("https://ok.ru/");
        driver.findElement(By.xpath("//div[@id='msg_toolbar_button']/div/div")).click();
        driver.findElement(By.xpath("//a[contains(@href, '/messages/575257627025')]")).click();
    }

    @Test
    public void testGoogle() throws Exception {
        driver.get("https://www.google.ru/search?newwindow=1&ei=3HPFW6DeFIfRswGY6Yr4DA&q=browser+string+test&oq=browser+string+test&gs_l=psy-ab.12...0.0.1.154.0.0.0.0.0.0.0.0..0.0....0...1..64.psy-ab..0.0.0....0.h2MuZAPMD80");
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("browser test");
        driver.findElement(By.cssSelector("svg")).click();
        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("browser test 2");
        driver.findElement(By.cssSelector("svg")).click();
        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("browser test 3");
        driver.findElement(By.cssSelector("svg")).click();
    }*/

    @Test
    public void myTest() throws Exception {
        driver.get("https://www.google.ru");
        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("vk");
        driver.findElement(By.xpath("//*[contains(@value, 'Поиск в Google') and contains(@type, 'button')]")).click();
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/h3/a")).click();
    }

    @Test
    public void messageOkTest() throws Exception {
        driver.get("https://ok.ru/");
        driver.findElement(By.xpath("//div[@id='hook_Block_HeaderTopFriendsInToolbar']/a/div/div")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Иван Кыльчик')])[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Написать')]")).click();
        driver.findElement(By.xpath("(//*[@class='itx_w']/*[@contenteditable='true'])")).click();
        driver.findElement(By.xpath("(//*[@class='itx_w']/*[@contenteditable='true'])")).sendKeys("Автоматизированное тестирование");
        driver.findElement(By.xpath("//div[3]/button")).click();
        driver.findElement(By.xpath("//div[@id='hook_Block_MessagesLayer']/div/span")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /*private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }*/
}
