package core.pages;

import core.HelperBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyGroupMainPage extends HelperBase {

    private static final By CREATE_GROUP = By.xpath(".//*[contains(@href,'st.layer.cmd=PopLayerCreateAltGroup')]");
    private static final By PAGE_TYPE = By.xpath("//*[contains(@data-l,'t,PAGE')]");
    private static final By GROUP_NAME = By.id("field_name");
    private static final By GROUP_DESCRIPTION = By.id("field_description");
    private static final By CREATE_NEW_GROUP = By.id("hook_FormButton_button_create");

    public MyGroupMainPage(WebDriver driver) {
        super(driver);
    }

    protected void check() {
        (new WebDriverWait(driver, 5)).until((ExpectedCondition<Boolean>) driver -> isElementPresent(CREATE_GROUP));

        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(CREATE_GROUP));
    }

    public void clickCreateButton() {
        click(CREATE_GROUP);
    }

    public void clickPublicPageType() {
        click(PAGE_TYPE);
    }

    public void typeGroupName() {
        type("Test", GROUP_NAME);
    }

    public void typeGroupDescription() {
        type("Test description", GROUP_DESCRIPTION);
    }

    public void clickCreateGroup() {
        Assert.assertTrue("CREATE_NEW_GROUP element not found", isElementPresent(CREATE_NEW_GROUP));
        click(CREATE_NEW_GROUP);
    }

}
