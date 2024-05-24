package models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Device extends PanacheEntity {
    public String mac;
    public String name;
    public int rssi;

}
