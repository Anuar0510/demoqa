package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

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
        $x("//input[@id='firstName']").setValue("Anuar");
        $x("//input[@id='lastName']").setValue("Omar");
        $x("//input[@id='userEmail']").setValue("omar051000@gmail.com");
        $x("//div[@class='custom-control custom-radio custom-control-inline']").click();
        $x("//input[@id='userNumber']").setValue("7064066838");
        $x("//div[@class='react-datepicker__input-container']").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--005:not(.react-datepicker__day--selected").click();
        $x("//input[@id='subjectsInput']").setValue("Chemistry").sendKeys(Keys.ENTER);
        $("#hobbiesWrapper").$(byText("Music")).click();
        $x("//input[@id='uploadPicture']").setValue("C:\\Users\\AOmar\\IdeaProjects\\demo_qa_test\\src\\test\\java\\pictures\\bloger-sokratil-naruto-na-115-chasov-radi-devushki_16494393021767498187.jpg");
        $x("//textarea[@id='currentAddress']").setValue("Country: Kazakhastan, City: Almaty, street:Abaya-34");
        $x("//div[@id='state']").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $x("//div[@id='city']").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Anuar Omar"),
                text("omar051000@gmail.com"),
                text("7064066838"),
                text("male"),
                text("05 October,2000"),
                text("Chemistry"),
                text("Music"),
                text("bloger-sokratil-naruto-na-115-chasov-radi-devushki_16494393021767498187.jpg"),
                text("Country: Kazakhastan, City: Almaty, street:Abaya-34"),
                text("NCR Noida"));
    }
}
