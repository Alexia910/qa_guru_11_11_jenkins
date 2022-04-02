package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class FormTest {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Test";
    String lastName = "Testovy";
    String userEmail = "pochta@tail.ru";
    String gender = "Male";
    String userNumber = "0123456789";
    String day = "15";
    String month = "June";
    String year = "1999";
    String subject = "Maths";
    String hobby = "Reading";
    // String namePicture = "picture.jpg";
    String adress = "Minsk";
    String state = "NCR";
    String city = "Delhi";
    String userName = firstName + " " + lastName;
    String date = day + " " + month + "," + year;


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

    @Test
    void successFillTest() {

        step("Открыть страницу", () -> {
            registrationPage.openPage();
        });

        step("Проверить хэдер", () -> {
            registrationPage.verifyHeader();
        });

        step("Ввести имя", () -> {
            registrationPage.setFirstName(firstName);
        });

        step("Ввести фамилию", () -> {
            registrationPage.setLastName(lastName);
        });

        step("Ввести почту", () -> {
            registrationPage.setUserEmail(userEmail);
        });

        step("Выбрать пол", () -> {
            registrationPage.setGender(gender);
        });

        step("Ввести номер телефона", () -> {
            registrationPage.setUserNumber(userNumber);
        });

        step("Выбрать дату рождения", () -> {
            registrationPage.setBirthDate(day, month, year);
        });

        step("Ввести предмет", () -> {
            registrationPage.setSubject(subject);
        });

        step("Выбрать хобби", () -> {
            registrationPage.setHobby(hobby);
        });

        /*  step("Загрузить файл", () -> {
            registrationPage.pictureUpload(namePicture);
        }); */

        step("Ввести адрес", () -> {
            registrationPage.setAdress(adress);
        });

        step("Выбрать штат", () -> {
            registrationPage.setState(state);
        });

        step("Выбрать город", () -> {
            registrationPage.setCity(city);
        });

        step("Отправить форму", () -> {
            registrationPage.sendForm();
        });

        step("Проверить форму", () -> {
            registrationPage.verifyForm(
                    userName,
                    userEmail,
                    gender,
                    userNumber,
                    date,
                    subject,
                    hobby,
                   // namePicture,
                    adress,
                    state,
                    city);
        });

    }
}