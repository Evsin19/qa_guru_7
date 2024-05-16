package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private final String endPoint = "/automation-practice-form";
    private final  SelenideElement

            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail =  $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarType = $("#dateOfBirthInput"),
            subjectsContainer = $("#subjectsContainer"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit"),
            userForm = $("#userForm");




    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResult = new CheckResultComponent();


    public PracticeFormPage openPage(){
        open(endPoint);
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this ;
    }

    public PracticeFormPage setFirstName(String value){
        firstName.setValue(value);
        return this ;
    }

    public PracticeFormPage setLastName(String value){
        lastName.setValue(value);
        return this ;
    }

    public PracticeFormPage setUserEmail(String value){
        userEmail.setValue(value);
        return this ;
    }

    public PracticeFormPage setGenterWrapper(String value){
        genderWrapper.$(byText(value)).click();
        return this ;
    }

    public PracticeFormPage setUserNumber(String value){
        userNumber.setValue(value);
        return this ;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year){
        calendarType.click();
        calendarComponent.setDate(day, month, year);
        return this ;
    }

    public PracticeFormPage setSubjectsContainer(String value){
        subjectsContainer.click();
        subjectsInput.setValue(value).pressEnter();
        return this ;
    }

    public PracticeFormPage setHobbiesWrapper(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this ;
    }

    public PracticeFormPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this ;
    }

    public PracticeFormPage setCurrentAddress(String value){
        currentAddress.setValue(value);
        return this ;
    }

    public PracticeFormPage setState(String value){
        state.click();
        stateCityWrapper.$(byText(value)).click();
        return this ;
    }

    public PracticeFormPage setCity(String value){
        city.click();
        stateCityWrapper.$(byText(value)).click();
        return this ;
    }

    public PracticeFormPage submit(){
        submit.click();
        return this ;
    }

    public PracticeFormPage checkResult(String key, String value){
        checkResult.result(key,value);
        return this ;
    }

    public PracticeFormPage checkValidation(){
        userForm.shouldHave(cssClass("was-validated"));
        return this;
    }
}
