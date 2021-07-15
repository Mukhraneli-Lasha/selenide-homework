import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.*;


@Listeners({ SoftAsserts.class})
public class Selenide {
    @Test
    public void configuration(){
        Configuration.startMaximized=true;
        //  timeout=20000;
        //   holdBrowserOpen=false;
        Configuration.reportsFolder = "test-result/reports";
        Configuration.startMaximized = true;
        reopenBrowserOnFail = true;
        fastSetValue=true;
        assertionMode= AssertionMode.SOFT;
        Configuration.fileDownload= FileDownloadMode.HTTPGET;
    }

}
