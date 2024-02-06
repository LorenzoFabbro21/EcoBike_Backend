package microservice.negozioservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shop")
public class Negozio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "id_user")
    private int id_user;

    public Negozio(long id, String name, String city, String address, int phone_number, int id_user) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone_number = phone_number;
        this.id_user = id_user;
    }

    public Negozio() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }


}
