package ch.over.limits.united.rest;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

import com.electronwill.nightconfig.core.conversion.Path;

import ch.over.limits.united.crm.persistence.Adresse;
import ch.over.limits.united.crm.persistence.Partner;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Builder;
import lombok.Data;

@Stateless
@Path("partner")
public class PartnerResource {
    @PersistenceContext
    private EntityManager entityManager;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPartner(CreatePartnerDto dto) {

        Partner partner = Partner.builder()
                .vorname(dto.getVorname())
                .name(dto.getName())
                .alter(dto.getAlter())
                .geschlecht(dto.getGeschlecht())
                .adresse(Adresse.builder()
                        .strasse(dto.getStrasse())
                        .nr(dto.getNr())
                        .plz(dto.getPlz())
                        .ort(dto.getOrt())
                        .land(dto.getLand())
                        .build())
                .bezahlinformationen(dto.getBezahlinformationen())
                .korrespondenzsprache(dto.getKorrespondenzsprache())
                .iban(dto.getIban())
                .kontoinhaber(dto.getKontoinhaber())
                .email(dto.getEmail())
                .sozialversicherungsnummer(dto.getSozialversicherungsnummer())
                .build();

        entityManager.persist(partner);
        return Response.status(Response.Status.CREATED).entity(partner).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all partners", description = "Returns a list of all registered partners.")
    @APIResponse(responseCode = "200", description = "Successfully retrieved the list")
    @APIResponse(responseCode = "500", description = "Internal server error") 
    public List<Partner> listPartner() {
        return entityManager.createQuery("SELECT p FROM Partner p", Partner.class).getResultList();
    }

    @Data
    @Builder
    public static class CreatePartnerDto {
        private String vorname;
        private String name;
        private int alter;
        private String geschlecht;
        private String strasse;
        private String nr;
        private String plz;
        private String ort;
        private String land;
        private String bezahlinformationen;
        private String korrespondenzsprache;
        private String iban;
        private String kontoinhaber;
        private String email;
        private String sozialversicherungsnummer;

    }
}