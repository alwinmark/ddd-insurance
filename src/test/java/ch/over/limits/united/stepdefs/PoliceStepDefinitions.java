package ch.over.limits.united.stepdefs;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import ch.over.limits.united.police.persistence.Police;
import ch.over.limits.united.police.persistence.Produkt;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PoliceStepDefinitions {
    private Police police;
    private Map<Long, Produkt> produkte = new HashMap<>();

    public PoliceStepDefinitions() {
        Produkt grundversicherung = Produkt.builder()
                .id(1l)
                .produktName("Grundversicherung")
                .beschreibung("Basis Krankenversicherung")
                .build();

        Produkt zusatzversicherung = Produkt.builder()
                .id(2l)
                .produktName("Zusatzversicherung")
                .beschreibung("Zusätzliche Leistungen")
                .build();

        produkte.put(grundversicherung.getId(), grundversicherung);
        produkte.put(zusatzversicherung.getId(), zusatzversicherung);
    }

    @Given("eine Police mit:")
    public void einePoliceMit(DataTable daten) {
        daten.asMaps(String.class, String.class).forEach(row -> {
            police = new Police();
            police.setPoliceNr(row.get("policeNr"));
            police.setVersicherungsnehmer(row.get("versicherungsnehmer"));
            police.setVersichertePerson(row.get("versichertePerson"));
            police.setKorrespondenzEmpfaenger(row.get("korrespondenzEmpfaenger"));
            police.setMonatlichePraemie(Double.parseDouble(row.get("monatlichePraemie")));
            // Füge Produkte zur Police hinzu (Beispielhaft, hier könnten mehr Details
            // ergänzt werden)
            police.setProdukte(
                produkte.values().stream().filter(produkt -> row.get("produkte").contains(produkt.getProduktName())).toList()
            );

        });
    }

    @Then("sollte die Police korrekt angelegt sein")
    public void sollteDiePoliceKorrektAngelegtSein() {
        assertNotNull(police);
        assertEquals("POL123", police.getPoliceNr());
        assertEquals("P12345", police.getVersicherungsnehmer());
        assertEquals("P12345", police.getVersichertePerson());
        assertEquals("P12345", police.getKorrespondenzEmpfaenger());
        assertEquals(350.50, police.getMonatlichePraemie(), 0.01);
        assertNotNull(police.getProdukte());
        assertEquals(2, police.getProdukte().size());
        assertEquals("Grundversicherung", police.getProdukte().get(0).getProduktName());
        assertEquals("Zusatzversicherung", police.getProdukte().get(1).getProduktName());
    }
}