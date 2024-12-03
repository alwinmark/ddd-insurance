package ch.over.limits.united.police.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import ch.over.limits.united.police.persistence.Produkt;

@Entity
public class Police {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String policeNr;
    private String versicherungsnehmer;
    private String versichertePerson;
    private String korrespondenzEmpfaenger;
    private double monatlichePraemie;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Produkt> produkte;

    // Getters und Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoliceNr() {
        return policeNr;
    }

    public void setPoliceNr(String policeNr) {
        this.policeNr = policeNr;
    }

    public String getVersicherungsnehmer() {
        return versicherungsnehmer;
    }

    public void setVersicherungsnehmer(String versicherungsnehmer) {
        this.versicherungsnehmer = versicherungsnehmer;
    }

    public String getVersichertePerson() {
        return versichertePerson;
    }

    public void setVersichertePerson(String versichertePerson) {
        this.versichertePerson = versichertePerson;
    }

    public String getKorrespondenzEmpfaenger() {
        return korrespondenzEmpfaenger;
    }

    public void setKorrespondenzEmpfaenger(String korrespondenzEmpfaenger) {
        this.korrespondenzEmpfaenger = korrespondenzEmpfaenger;
    }

    public double getMonatlichePraemie() {
        return monatlichePraemie;
    }

    public void setMonatlichePraemie(double monatlichePraemie) {
        this.monatlichePraemie = monatlichePraemie;
    }

    public List<Produkt> getProdukte() {
        return produkte;
    }

    public void setProdukte(List<Produkt> produkte) {
        this.produkte = produkte;
    }
}
