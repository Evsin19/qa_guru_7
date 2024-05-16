package tests;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.TestData;

import static pages.components.DateComponent.dateNow;


public class PracticeFormTest extends TestBase{
    TestData testData = new TestData();
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fullFormTests() {

        practiceFormPage.openPage()
                        .setFirstName(testData.firstName)
                        .setLastName(testData.lastName)
                        .setUserEmail(testData.userEmail)
                        .setGenterWrapper(testData.gender)
                        .setUserNumber(testData.userNumber)
                        .setDateOfBirth(testData.day, testData.month, testData.year)
                        .setSubjectsContainer(testData.subject)
                        .setHobbiesWrapper(testData.hobbie)
                        .uploadPicture(testData.picture)
                        .setCurrentAddress(testData.currentAddress)
                        .setState(testData.state)
                        .setCity(testData.city)
                        .submit()

                        .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Student Email", testData.userEmail)
                        .checkResult("Gender", testData.gender)
                        .checkResult("Mobile", testData.userNumber)
                        .checkResult("Date of Birth", testData.day + " " + testData.month + "," +testData.year)
                        .checkResult("Subjects",testData.subject)
                        .checkResult("Hobbies",testData.hobbie)
                        .checkResult("Picture",testData.picture)
                        .checkResult("Address",testData.currentAddress)
                        .checkResult("State and City",testData.state + " " + testData.city);


    }

    @Test
    void minFormTests() {

        practiceFormPage.openPage()
                        .setFirstName(testData.firstName)
                        .setLastName(testData.lastName)
                        .setGenterWrapper(testData.gender)
                        .setUserNumber(testData.userNumber)
                        .submit()

                        .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                        .checkResult("Gender", testData.gender)
                        .checkResult("Date of Birth", dateNow());
    }

    @Test
    void validationFormTests() {

        practiceFormPage.openPage()
                        .submit()

                        .checkValidation();
    }


}
