package microservice.recensioneservice.model;

import jakarta.persistence.*;
@Entity
@Table(name = "review")
public class Recensione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "score")
    private int score;

    @Column(name = "idUser")
    private int idUser; //Utente

    public Recensione() {

    }

    public Recensione(String text, int score, int idUser) {
        this.text = text;
        this.score = score;
        this.idUser = idUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}