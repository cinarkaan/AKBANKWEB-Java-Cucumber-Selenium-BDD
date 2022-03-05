package Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    public JavascriptExecutor javascriptExecutor;

    private String Url = "https://www.akbank.com/tr-tr/sayfalar/default.aspx";

    public Base (String Key, String Path) {
        System.setProperty(Key,Path);
    }

    public void after () {
        webDriver.quit();
    }

    public String getUrl () {
        return this.Url;
    }

}
