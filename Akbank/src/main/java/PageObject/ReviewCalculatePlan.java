package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReviewCalculatePlan {

    JavascriptExecutor javascriptExecutor;
    Actions actions;

    @FindBy(how = How.CLASS_NAME, using = "jspDrag")
    private WebElement scrollDrag;

    public ReviewCalculatePlan (WebDriver webDriver, JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
        this.actions = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void scrollDown () {
        javascriptExecutor.executeScript("window.scroll(0,1200)");
        actions.dragAndDropBy(scrollDrag,0,295);
        actions.perform();
        System.out.println("Table scrolled down was successfully until 20th is seen");
    }

}
