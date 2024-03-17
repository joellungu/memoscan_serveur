package defunt;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Couverture extends PanacheEntity {
    public Long idDef;
    public byte[] media;
}
