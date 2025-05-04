package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.SubmittingFormComponent;

import static tests.TestData.*;

public class PracticeFormJavaFakerTest extends TestBase {

    PracticeFormPage practiceForm = new PracticeFormPage();
    SubmittingFormComponent submittingForm = new SubmittingFormComponent();

    @Test
    @DisplayName("Проверка успешного заполнения всех полей формы")
    void successfulSubmitTest() {
        practiceForm
                .openPage()
                .removeBanner();

        practiceForm
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobilePhone(mobile)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        submittingForm
                .checkForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", stateAndCity);
    }

    @Test
    @DisplayName("Проверка успешного заполнения обязательных полей формы")
    void successfulRequiredSubmitTest() {
        practiceForm
                .openPage()
                .removeBanner();

        practiceForm
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobilePhone(mobile)
                .submit();

        submittingForm
                .checkForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile);
    }

    @Test
    @DisplayName("Валидация обязательных полей формы")
    void validationRequiredSubmitTest() {
        practiceForm
                .openPage()
                .removeBanner();

        practiceForm
                .setLastName(lastName)
                .setGender(gender)
                .setMobilePhone(mobile)
                .submit();

        submittingForm
                .absenceForm();
    }
}
