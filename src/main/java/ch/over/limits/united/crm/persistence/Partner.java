package ch.over.limits.united.crm.persistence;

import javax.persistence.*;

import lombok.Builder;

@Entity
@Builder
public class Partner{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String partnerNr;
    private String vorname;
    private String name;
    private int alter;
    private String geschlecht;
    
    @Embedded
    private Adresse adresse;
    private String bezahlinformationen;
    private String korrespondenzsprache;
    private String iban;
    private String kontoinhaber;
    private String email;
    private String sozialversicherungsnummer;

    public String getPartnerNr() {
        return partnerNr;
    }

    public void setPartnerNr(String partnerNr) {
        this.partnerNr = partnerNr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getBezahlinformationen() {
        return bezahlinformationen;
    }

    public void setBezahlinformationen(String bezahlinformationen) {
        this.bezahlinformationen = bezahlinformationen;
    }

    public String getKorrespondenzsprache() {
        return korrespondenzsprache;
    }

    public void setKorrespondenzsprache(String korrespondenzsprache) {
        this.korrespondenzsprache = korrespondenzsprache;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSozialversicherungsnummer() {
        return sozialversicherungsnummer;
    }

    public void setSozialversicherungsnummer(String sozialversicherungsnummer) {
        this.sozialversicherungsnummer = sozialversicherungsnummer;
    }
}

