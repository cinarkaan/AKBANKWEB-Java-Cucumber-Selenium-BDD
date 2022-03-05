package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    JavascriptExecutor javascriptExecutor;

    public HomePage (WebDriver webDriver, String Url, JavascriptExecutor javascriptExecutor) {
        webDriver.get(Url);
        this.javascriptExecutor = javascriptExecutor;
        PageFactory.initElements(webDriver, this);
    }

    public void scrollDown () {
        javascriptExecutor.executeScript("window.scroll(0,880)");
    }

}
