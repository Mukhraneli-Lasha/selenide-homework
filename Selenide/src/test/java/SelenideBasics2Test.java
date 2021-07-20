import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.assertionMode;
import static com.codeborne.selenide.Selenide.*;




@Listeners({ SoftAsserts.class})
public class SelenideBasics2Test {


   public void SelenideTestss() {
      Configuration.startMaximized = true;
      baseUrl = "https://demoqa.com";
      reopenBrowserOnFail = true;
      fastSetValue = true;
      assertionMode = AssertionMode.SOFT;
      Configuration.fileDownload = FileDownloadMode.HTTPGET;

   }

   @Test
   public void books(){
      SelenideTestss();
      open("/books");


      ElementsCollection Js = $(".rt-tbody").$$(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("JavaScript"));
      System.out.println(Js.size());
      System.out.println(Js);



      // $$("rt-tr-group").shouldHave(sizeGreaterThanOrEqual(10)); -- failed
      $$("rt-tr-group").shouldHave(sizeNotEqual(10));



      $(".rt-table").$("rt-tbody").$$(".rt-tr-group img");
      System.out.println( " images are not empty :" + $$(".rt-tr-group img").isEmpty());


   }

}
