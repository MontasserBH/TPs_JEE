package friendsofmine.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.SplittableRandom;

/**
 * Created by SoF on 01/04/2017.
 */

public class Utilisateur {

    @NotNull
    @Size(min = 1, max = 255)
    private String nom;

    @NotNull
    @Size(min = 1, max = 255)
    private String prenom;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp="^[MF]{1}$")
    private String sexe;

    private Date dateNaissance;

    public Utilisateur(){

    }
    public Utilisateur(String nom, String prenom, String email, String sexe, Date dateNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
    }
    public Utilisateur(String nom, String prenom, String email, String sexe){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.sexe = sexe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
}
