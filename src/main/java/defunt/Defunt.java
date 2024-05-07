package defunt;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

import java.util.List;

@Entity
public class Defunt extends PanacheEntity {
    //
    public String qrcode;
    public String nom;
    public String postnom;
    public String prenom;
    public String dateNaissance;
    public String dateDece;
    public byte[] profile;
    public Boolean photoProfile;
    public String idAcces;
    public String cimetiere;
    public String adresseCimetiere;
    //@ElementCollection
    public String quartier;
    public String avenue;
    public String numeroTombo;
    //public List<MultiMedia> multiMedias;

}
