package PageObject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentPlan {

    JavascriptExecutor javascriptExecutor;

    @FindBy(how = How.ID, using = "accordion3")
    private WebElement calculateAndCostRate;

    @FindBy(how = How.ID, using = "accordion4")
    private WebElement calculatePlan;

    public PaymentPlan(WebDriver webDriver, JavascriptExecutor javascriptExecutor) {
        this.javascriptExecutor = javascriptExecutor;
        PageFactory.initElements(webDriver, this);
    }

    public void clickCalculateDetails() {
        javascriptExecutor.executeScript("document.querySelector(\"#ctl00_ctl43_g_bc9fb7f8_9c96_49d0_b1fb_1212b341455e > div.box.module303.revised.big.initJsActivated > div > div:nth-child(3) > div.content.has-footer.text-white > div > div.result > a\").click()");
        System.out.println("Clicked calculate details was successfully ");
    }

    public void setCalculateAndCostRate() {
        Assert.assertEquals("Masraf ve Maliyet Oranları",calculateAndCostRate.getText());
        System.out.println("Cost Rate Checked and clicked");
    }

    public void clickPaymentPlan () {
        javascriptExecutor.executeScript("document.querySelector(\"#accordion4\").click()");
        System.out.println("Clicked payment plan was successfully");
    }

    public void setCalculatePlan() {
        Assert.assertEquals("Ödeme Planı",calculatePlan.getText());
        System.out.println("Payment Plan Checked");
    }

}
