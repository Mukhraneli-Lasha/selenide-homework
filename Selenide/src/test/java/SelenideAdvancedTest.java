import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;




@Listeners({ScreenShooter.class, SoftAsserts.class})
public class SelenideAdvancedTest {
    @BeforeClass
    public void configSetup(){
        fastSetValue = true;
        Configuration.startMaximized = true;
        assertionMode= AssertionMode.SOFT;
        baseUrl = "https://demoqa.com";
        Configuration.fileDownload = FileDownloadMode.HTTPGET;
        reopenBrowserOnFail = true;
        ScreenShooter.captureSuccessfulTests = true;

    }

    @Test
    public  void javascript() {

        ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to(" src/main/resources/Reports");

        open("/books");
        ElementsCollection jscript = $(".rt-tbody").findAll(by("role", "rowgroup")).filterBy(text("O'Reilly Media")).filterBy(text("Javascript"));

        System.out.println(jscript.size());
        System.out.println(jscript);


                         //Failed case

          Assert.assertEquals(jscript.size(),10,"assert is wrong");


                         //success case

        //  Assert.assertEquals(jscript.size(),3,"assert is wrong");


        jscript.first().shouldHave(text( "Learning JavaScript Design Patterns"));



jscript.stream().forEach(el -> { actions().moveToElement(el.scrollTo().$(".mr-2")).keyDown(Keys.CONTROL).click().perform();


        });


    }
}
