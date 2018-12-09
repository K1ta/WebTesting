package core.pages;

import core.HelperBase;
import core.PersonalDataWrapper;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class NewMyAboutPage extends HelperBase implements IAboutPage {

    public NewMyAboutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    @Override
    public void addSchool(String school) {

    }

    @Override
    public String getCityOfResidence() {
        return null;
    }

    @Override
    public String getHometown() {
        return null;
    }

    @Override
    public String getBirthdate() {
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public void typeInterestSection(String section, String text) {

    }

    @Override
    public void clickAddInterestSection(String section) {

    }

    @Override
    public void clearInterestSection(String section) {

    }

    @Override
    public List<String> getInterestSectionList(String section) {
        return null;
    }

    @Override
    public PersonalDataWrapper modifyPersonalData() {
        return null;
    }

    @Override
    public MyProfilePage clickProfile() {
        return null;
    }
}
