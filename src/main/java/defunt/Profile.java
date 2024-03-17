package defunt;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Profile extends PanacheEntity {
    public Long idDef;
    public byte[] media;
}
