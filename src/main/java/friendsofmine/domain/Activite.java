package friendsofmine.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SoF on 01/04/2017.
 */

public class Activite {

    @NotNull
    @Size(min=1, max=255)
    private String titre;

    private String descriptif;

    public Activite(){

    }

    public Activite(String titre, String descriptif){
        this.titre = titre;
        this.descriptif = descriptif;
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
}
