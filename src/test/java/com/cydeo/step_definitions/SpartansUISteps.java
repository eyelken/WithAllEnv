package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpartansUISteps {
    @Given("Commander is at the main page")
    public void commander_is_at_the_main_page() {
        Driver.get().get(ConfigurationReader.get("spartan.webUrl"));
    }
    @When("Commander clicks on view button of the spartan with the ID number {int}")
    public void commander_clicks_on_view_button_of_the_spartan_with_the_id_number(Integer int1) {

    }
    @Then("Verifies the name of the spartan is {string}")
    public void verifies_the_name_of_the_spartan_is(String string) {

    }

}
