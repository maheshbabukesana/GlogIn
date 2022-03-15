package StepDefinations;


import Contracts.Login;
import Screen.GloginScreen;
import io.cucumber.java.en.*;
import org.testng.Assert;



public class Steps  {

    Login login = new GloginScreen();

    @Given("open Browser")
    public void open_browser() {
        login.startDriver();
    }

    @And("User navigate to the Google page")
    public void user_navigate_to_the_google_page() {

        login.navigateGooglePage();

    }
    @Then("Accept the cookies")
    public void accept_the_cookies() {
      login.acceptCookies();

    }

   @Given("I click the Accedi button in Google page")
    public void i_click_the_accedi_button_in_google_page() {
        login.clickAccedi();

    }
    @Then("I should see the Google Accedi page")
    public void i_should_see_the_google_accedi_page() {
        Assert.assertTrue( login.isAccedipageDisplayed(), "unable to find  Gmail page ");
    }
    @When("I enter the vaild Mail Id")
    public void i_enter_the_vaild_mail_id() {
        login.enterValidId();
    }

    @And("I enter the vaild password")
    public void i_enter_the_vaild_password() {
      login.enterPassword();
    }

    @Then("I should see the mail Avatar in google page")
    public void i_should_see_the_mail_avatar_in_google_page() {
        Assert.assertTrue(login.isMailAvatarDisplayed(), "unable to find  Mail Avtar ");
    }

    @Given("I type in searchbar")
    public void i_type_in_searchbar() {
       login.searchKeyword();
    }
    @Then("I have to print all the links")
    public void i_have_to_print_all_the_links() {
        login.printLinks();
    }
}
