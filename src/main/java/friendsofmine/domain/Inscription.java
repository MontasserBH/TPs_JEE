package friendsofmine.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by SoF on 02/04/2017.
 */
@Entity
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @NotNull
    @ManyToOne
    private Utilisateur participant;

    @NotNull
    @ManyToOne
    private Activite activite;

    private Date dateInscription;

    public Inscription(){

    }

    public Inscription(Utilisateur utilisateur, Activite activite, Date date){
        this.participant = utilisateur;
        this.activite = activite;
        this.dateInscription = date;
    }

    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur participant) {
        this.participant = participant;
    }

    public Activite getActivite() {
        return activite;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @PrePersist
    public void updateDate(){
        if(this.dateInscription == null){
            setDateInscription(new Date());
        }
    }
}
