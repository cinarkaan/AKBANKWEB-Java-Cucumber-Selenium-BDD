package StepDefinitions;

import Base.BaseFactory;
import PageObject.CreditInformation;
import PageObject.HomePage;
import PageObject.PaymentPlan;
import PageObject.ReviewCalculatePlan;
import Util.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {



    BaseFactory baseFactory = new BaseFactory();
    Base base;

    public StepDefinition() {
        base = baseFactory.getBase("Edge");
    }

    @Given("^: HomePage will be opened$")
    public void getCreditCalculation () {
        HomePage homePage = new HomePage(base.webDriver, base.getUrl(), base.javascriptExecutor);
        homePage.scrollDown();
    }

    @When("^: Credit Information part will be entered \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterInformation (String creditAmount,String insurance,String termPeriod) throws Exception{
        CreditInformation creditInformation = new CreditInformation(base.webDriver, base.javascriptExecutor);
        creditInformation.clickCreditType();
        creditInformation.setSelectCreditType();
        Thread.sleep(500);
        creditInformation.setCreditAmount(creditAmount);
        creditInformation.setInsured(insurance);
        creditInformation.setTermSlider(Integer.parseInt(termPeriod));
        System.out.println("CREDIT INFORMATION ENTERED WAS SUCCESSFULLY");
   }

    @And("^: Payment Plan will be opened$")
    public void openPaymentPlan () throws Exception{
        PaymentPlan paymentPlan = new PaymentPlan(base.webDriver, base.javascriptExecutor);
        paymentPlan.clickCalculateDetails();
        Thread.sleep(200);
        paymentPlan.setCalculateAndCostRate();
        paymentPlan.clickPaymentPlan();
        Thread.sleep(200);
        paymentPlan.setCalculatePlan();
        System.out.println("PAYMENT PLAN OPENED WAS SUCCESSFULLY");
    }

    @Then("^: Page will be scrolled down until 20th is seen$")
    public void showPaymentPlan () throws Exception{
        ReviewCalculatePlan reviewCalculatePlan = new ReviewCalculatePlan(base.webDriver, base.javascriptExecutor);
        reviewCalculatePlan.scrollDown();
        Thread.sleep(500);
        base.after();
        System.out.println("TEST CASE WAS SUCCESSFULLY");
    }

}
