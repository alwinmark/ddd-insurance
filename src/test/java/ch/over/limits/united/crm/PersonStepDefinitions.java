package ch.over.limits.united.crm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import ch.over.limits.united.crm.persistence.Partner;

public class PersonStepDefinitions {
    private Partner person;

    @Given("eine neue Person mit Name {string} und Vorname {string}")
    public void eineNeuePersonMitNameUndVorname(String name, String vorname) {
        person = new Partner();
        person.setName(name);
        person.setVorname(vorname);
    }

    @When("das Alter auf {int} gesetzt wird")
    public void dasAlterAufGesetztWird(int alter) {
        person.setAlter(alter);
    }

    @Then("sollte das Alter {int} sein")
    public void sollteDasAlterSein(int erwartetesAlter) {
        assertEquals(erwartetesAlter, person.getAlter());
    }
}