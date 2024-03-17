package defunt;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

@Entity
public class Biographie extends PanacheEntity {
    public Long idDef;
    @Lob
    public String text;
}
