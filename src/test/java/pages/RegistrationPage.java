package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();


    //locators
    private SelenideElement mainHeader = $(".main-header");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement numberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectInput = $("#subjectsInput");
    private SelenideElement pictureInput =  $("#uploadPicture");
    private SelenideElement adressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#react-select-3-input");
    private SelenideElement cityInput = $("#react-select-4-input");
    private SelenideElement buttonSubmit = $("#submit");
    private SelenideElement tableResponsive = $(".table-responsive");




   //actions
   public void openPage(){
       open("/automation-practice-form");
   }
   public void verifyHeader(){
       mainHeader.shouldHave(text("Practice Form"));
   }
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }
    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }
    public void setUserEmail(String userEmail) {
        emailInput.setValue(userEmail);
    }
    public void setGender(String gender) {
        $(byText(gender)).click();
    }
    public void setUserNumber(String userNumber) {
        numberInput.setValue(userNumber);
    }
    public void setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
    }
    public void setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
    }
    public void setHobby(String hobby) {
        $(byText(hobby)).click();
    }
    public void pictureUpload(String namePicture) {
        pictureInput.uploadFromClasspath(namePicture);
    }
    public void setAdress(String adress) {
        adressInput.setValue(adress);
    }
    public void setState(String state) {
        stateInput.setValue(state).pressEnter();
    }
    public void setCity(String city) {
        cityInput.setValue(city).pressEnter();
    }
    public void sendForm() {
        buttonSubmit.click();
    }
    public void verifyForm(String userName,
                           String userEmail,
                           String gender,
                           String userNumber,
                           String date,
                           String subject,
                           String hobby,
                          // String namePicture,
                           String adress,
                           String state,
                           String city) {
       tableResponsive.shouldHave(text(userName),
               text(userEmail),
               text(gender),
               text(userNumber),
               text(date),
               text(subject),
               text(hobby),
              // text(namePicture),
               text(adress),
               text(state + " " + city));
    };
}
