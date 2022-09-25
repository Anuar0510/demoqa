package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void textBox(){
        open("text-box");
        $(By.xpath("//input[@id='userName']")).setValue("Omar Anuar");
        $(By.xpath("//input[@type='email']")).setValue("omar051000@gmail.com");
        $(By.xpath("//textarea[@id='currentAddress']")).setValue("Country: Kazakhastan, City: Almaty, street:Abaya-34");
        $(By.xpath("//textarea[@id='permanentAddress']")).setValue("Country: Kazakhastan, City: Almaty, street:Abaya-35");
        $(By.xpath("//button[@id='submit']")).click();

        $("#output #name").shouldHave(text("Omar Anuar"));
        $("#output #email").shouldHave(text("omar051000@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Country: Kazakhastan, City: Almaty, street:Abaya-34"));
        $("#output #permanentAddress").shouldHave(text("Country: Kazakhastan, City: Almaty, street:Abaya-35"));


    }
}
