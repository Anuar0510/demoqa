package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

    }
    @Test
    void automationPracticeForm(){
        open("automation-practice-form");
        zoom(0.5);
        $("#firstName").setValue("Anuar");
        $("#lastName").setValue("Omar");
        $("#userEmail").setValue("omar051000@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7064066838");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--005:not(.react-datepicker__day--selected").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("Country: Kazakhastan, City: Almaty, street:Abaya-34");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Anuar Omar"),
                text("omar051000@gmail.com"),
                text("7064066838"),
                text("male"),
                text("05 October,2000"),
                text("Chemistry"),
                text("Music"),
                text("1.jpg"),
                text("Country: Kazakhastan, City: Almaty, street:Abaya-34"),
                text("NCR Noida"));
    }
}
