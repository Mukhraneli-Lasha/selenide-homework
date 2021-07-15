import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


@Listeners({ SoftAsserts.class})
public class Selenide {
    @Test
    public void configuration(){
        Configuration.startMaximized=true;
        //  timeout=20000;
        //   holdBrowserOpen=false;
        Configuration.reportsFolder = "test-result/reports";

        reopenBrowserOnFail = true;
        fastSetValue=true;
        assertionMode= AssertionMode.SOFT;
        Configuration.fileDownload= FileDownloadMode.HTTPGET;
    }
    @Test
    public void checkBoxes(){
        Configuration.startMaximized=true;
        open("http://the-internet.herokuapp.com/checkboxes  ");
        $(byXpath("//form/input[1]")).click();
        $("#checkboxes").shouldBe(visible);
        $(byXpath("//input[@type='checkbox']")).shouldHave(type("checkbox"));
        $(byXpath("//input[@type='checkbox']")).shouldBe(checked);
//$("#checkboxes").shouldHave(type("checkbox"));
    }
    @Test
    public void dropDown(){
        Configuration.startMaximized=true;
        open("http://the-internet.herokuapp.com/dropdown");
        $("#dropdown").shouldHave().isSelected();
        SelenideElement selenide = $("#dropdown");
        selenide.selectOptionContainingText("Option 2");
        $(byText("Option 2")).isSelected();
        $(byText("Option 2")).setSelected(true);
    }
    @Test
    public void textBox(){
        Configuration.startMaximized=true;
        open("https://demoqa.com/text-box");
        $("#userName").setValue("lasha ");
        $(byXpath("//input[@placeholder='name@example.com']")).setValue("lasha.mukhraneli.1@gmail.com");
        $("#currentAddress").setValue("Rustavi");
        $(byXpath("//textarea[@id='permanentAddress']")).setValue("tbilisi --");
        $("#submit").scrollTo().click();


        $$(byClassName("mb-1")).shouldHave(texts("Name:lasha","Email:lasha.mukhraneli.1@gmail.com", "Current Address :Rustavi", "Permananet Address :tbilisi --" ));



    }

}
