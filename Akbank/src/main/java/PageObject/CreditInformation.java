package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreditInformation {

    JavascriptExecutor javascriptExecutor;
    Actions actions;

    @FindBy(how = How.ID, using = "consumer-loans-price")
    private WebElement creditAmount;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ctl00_ctl43_g_bc9fb7f8_9c96_49d0_b1fb_1212b341455e\"]/div[1]/div/div[1]/div[1]/select")
    private WebElement selectCreditType;

    @FindBy(how = How.ID, using = "consumer-loans-vade")
    private WebElement termSlider;

    public CreditInformation (WebDriver webDriver, JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
        this.actions = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void setCreditAmount (String amount) {
        creditAmount.clear();
        creditAmount.sendKeys(amount);
        System.out.println(amount + " entered was successfully");
    }

    public void clickCreditType () {
        javascriptExecutor.executeScript("document.querySelector(\"#ctl00_ctl43_g_bc9fb7f8_9c96_49d0_b1fb_1212b341455e > div.box.module303.revised.big.initJsActivated > div > div.header.multiple-module-head > div.custom-select-wrapper > div > div > div > div\").click()");
    }

    public void setSelectCreditType() {
        Select select = new Select(selectCreditType);
        select.selectByValue("1");
        System.out.println("Click credit calculate was successfully");
    }

    public void setInsured (String insured) {
        if (insured.equals("insured")){
            javascriptExecutor.executeScript("document.querySelector(\"#ctl00_ctl43_g_bc9fb7f8_9c96_49d0_b1fb_1212b341455e > div.box.module303.revised.big.initJsActivated > div > div:nth-child(3) > div.content.has-footer.text-white > div > div.entry.div-sep-shadow > div > fieldset > div > div:nth-child(2) > a\").click()");
        } else {
            javascriptExecutor.executeScript("document.querySelector(\"#ctl00_ctl43_g_bc9fb7f8_9c96_49d0_b1fb_1212b341455e > div.box.module303.revised.big.initJsActivated > div > div:nth-child(3) > div.content.has-footer.text-white > div > div.entry.div-sep-shadow > div > fieldset > div > div:nth-child(1) > a\").click()");
        }
        System.out.println(insured + " selected was successfully");
    }

    public void setTermSlider (int termPeriod){
        actions.dragAndDropBy(termSlider, termPeriod/4 ,0);
        actions.perform();
        System.out.println(termPeriod + " selected was successfully");
    }

}
