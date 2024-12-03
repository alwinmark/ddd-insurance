package ch.over.limits.united.crm.persistence;

import javax.persistence.Embeddable;

import lombok.Builder;

@Embeddable
@Builder
public class Adresse {
    private String strasse;
    private String nr;
    private String plz;
    private String ort;
    private String land;

    // Getters und Setters
    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
