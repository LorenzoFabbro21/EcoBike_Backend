package microservice.userservice.model;

import jakarta.persistence.*;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nomeProvaK3Diff")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "telefono")
    private int telefono;

    public User() {
    }

    public User(String nome, String cognome, String mail, String password, int telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.password = password;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
