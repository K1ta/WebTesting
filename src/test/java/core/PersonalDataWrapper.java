package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PersonalDataWrapper extends HelperBase {

    private By SEX_MALE = By.xpath("//*[@name='fr.gender' and @value=1]");
    private By SEX_FEMALE = By.xpath("//*[@name='fr.gender' and @value=2]");
    private By CITY_OF_RESIDENCE = By.xpath("//*[@id='field_citySugg_SearchInput']");
    private By HOMETOWN = By.xpath("//*[@id='field_cityBSugg_SearchInput']");
    private By CITY_SUGGEST = By.xpath("//*[@class='suggest_li']");
    private By NAME = By.xpath("//*[@id='field_name']");
    private By SURNAME = By.xpath("//*[@id='field_surname']");
    private By SAVE_DATA = By.xpath("//*[@class='button-pro form-actions_yes']");
    private By SAVE_CLOSE = By.xpath("//*[@id='buttonId_button_close']");
    private By CLOSE_WITHOUT_SAVING = By.xpath("//*[@class='ic modal-new_close_ico']");
    private By ERROR = By.xpath("//*[contains(@class,'form_i__error')]");

    private final String DAY_START = "//*[@id='field_bday']/node()[@value=";
    private final String MONTH_START = "//*[@id='field_bmonth']/node()[@value=";
    private final String YEAR_START = "//*[@id='field_byear']/node()[@value=";

    public enum Sex {
        Male,
        Female
    }

    public PersonalDataWrapper(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void check() {

    }

    public void setSex(Sex sex) {
        if (sex == Sex.Male) {
            click(SEX_MALE);
        } else {
            click(SEX_FEMALE);
        }
    }

    public void setCityOfResidence(String city) {
        type(city, CITY_OF_RESIDENCE);
        click(CITY_SUGGEST);
    }

    public void setHometown(String city) {
        type(city, HOMETOWN);
        click(CITY_SUGGEST);
    }

    public void setName(String name) {
        type(name, NAME);
    }

    public void setSurname(String surname) {
        type(surname, SURNAME);
    }

    public void setBirthDay(int day) {
        click(By.xpath(DAY_START + day + "]"));
    }

    public void setBirthMonth(int month) {
        click(By.xpath(MONTH_START + month + "]"));
    }

    public void setBirthYear(int year) {
        click(By.xpath(YEAR_START + year + "]"));
    }

    public void save() {
        click(SAVE_DATA);
        if (!error()) {
            click(SAVE_CLOSE);
        }
    }

    public void cancel() {
        click(CLOSE_WITHOUT_SAVING);
    }

    public boolean error() {
        return isElementPresent(ERROR);
    }
}
