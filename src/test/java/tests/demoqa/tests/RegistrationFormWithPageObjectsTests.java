package tests.demoqa.tests;

import org.junit.jupiter.api.Test;
import tests.demoqa.pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    String firstName = "Darth";
    String lastName = "Vader";
    String email = "darty@gmail.com";
    String mobile = "0123456789";
    String subjects = "Eng";
    String currentAddress = "Empire, Death Star";


    @Test
    void fillFormTest() {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender("Male")
                    .setNumber(mobile)
                    .setBirthDate("30", "November", "1986")
                    .setSubjects(subjects)
                    .setHobbies("Sports")
                    .setHobbies("Reading")
                    .setHobbies("Music")
                    .uploadPicture("img/QA-Tester-meme-03.jpg")
                    .setAddress(currentAddress)
                    .setStateAndCity("NCR", "Noida")
                    .clickSubmit();
        });

        step("Check form results", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", mobile)
                    .checkResult("Date of Birth", "30 November,1986")
                    .checkResult("Subjects", "English")
                    .checkResult("Hobbies", "Sports, Reading, Music")
                    .checkResult("Picture", "QA-Tester-meme-03.jpg")
                    .checkResult("Address", currentAddress)
                    .checkResult("State and City", "NCR Noida");
        });
    }
}
