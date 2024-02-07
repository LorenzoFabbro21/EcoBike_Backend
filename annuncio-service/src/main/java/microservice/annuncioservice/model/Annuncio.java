package microservice.annuncioservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "announcement")
public abstract class Annuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "price")
    private int price;

    @Column(name = "id_bike")
    private int id_bike;

    @Column(name = "id_user")
    private int id_user;

    @Column(name = "type")
    private String type;

    public Annuncio() {
    }

    public Annuncio(long id, int price, int id_bike, int id_user, String type) {
        this.id = id;
        this.price = price;
        this.id_bike = id_bike;
        this.id_user = id_user;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_bike() {
        return id_bike;
    }

    public void setId_bike(int id_bike) {
        this.id_bike = id_bike;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
