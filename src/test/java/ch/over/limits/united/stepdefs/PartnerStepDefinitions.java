package ch.over.limits.united.stepdefs;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import ch.over.limits.united.crm.persistence.Partner;
import ch.over.limits.united.rest.PartnerResource.CreatePartnerDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PartnerStepDefinitions {

    private Map<String, Partner> partners = new HashMap<>();

    private static final String BASE_URL = "http://localhost:9080/api";

    @Given("neue Partner mit:")
    public void neuePartnerMit(DataTable dataTable) {

        dataTable.asMaps(String.class, String.class).stream().forEach((row) -> {
            CreatePartnerDto createPartnerDto = CreatePartnerDto.builder()
            .vorname(row.get("vorname"))
            .name(row.get("name"))
            .alter(Integer.parseInt(row.get("alter")))
            .geschlecht(row.get("geschlecht"))

            .strasse(row.get("strasse"))
            .nr(row.get("nr"))
            .plz(row.get("plz"))
            .ort(row.get("ort"))
            .land(row.get("land"))

            .bezahlinformationen(row.get("bezahlinformationen"))
            .korrespondenzsprache(row.get("korrespondenzsprache"))
            .iban(row.get("iban"))
            .kontoinhaber(row.get("kontoinhaber"))
            .email(row.get("email"))
            .sozialversicherungsnummer(row.get("sozialversicherungsnummer"))

            .build();


            var response = given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(createPartnerDto)
                .post("/partner");

            assertEquals(201, response.statusCode());
            Partner partner = response.as(Partner.class);
            this.partners.put(partner.getPartnerNr(), partner);
        });

    }
}