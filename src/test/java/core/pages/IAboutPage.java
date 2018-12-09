package core.pages;

import core.PersonalDataWrapper;

import java.util.List;

public interface IAboutPage {

    void addSchool(String school);

    String getCityOfResidence();

    String getHometown();

    String getBirthdate();

    String getFullName();

    void typeInterestSection(String section, String text);

    void clickAddInterestSection(String section);

    void clearInterestSection(String section);

    List<String> getInterestSectionList(String section);

    PersonalDataWrapper modifyPersonalData();

    MyProfilePage clickProfile();
}
