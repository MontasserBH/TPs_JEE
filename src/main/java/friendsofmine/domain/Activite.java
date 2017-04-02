package friendsofmine.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SoF on 01/04/2017.
 */
@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @NotNull
    @Size(min=1, max=255)
    private String titre;

    private String descriptif;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur responsable;

    public Activite(){

    }

    public Activite(String titre, String descriptif, Utilisateur responsable){
        this.titre = titre;
        this.descriptif = descriptif;
        this.responsable = responsable;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getTitre() {

        return titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public Long getId () {
        return id ;
    }
    private void setId ( Long id ) {
        this . id = id ;
    }

    public Utilisateur getResponsable() {
        return responsable;
    }

    public void setResponsable(Utilisateur responsable) {
        this.responsable = responsable;
    }
}
