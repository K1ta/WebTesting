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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void addSchool(String school) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getCityOfResidence() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getHometown() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getBirthdate() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String getFullName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void typeInterestSection(String section, String text) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void clickAddInterestSection(String section) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void clearInterestSection(String section) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<String> getInterestSectionList(String section) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public PersonalDataWrapper modifyPersonalData() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public MyProfilePage clickProfile() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
