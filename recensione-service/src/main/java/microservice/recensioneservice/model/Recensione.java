package microservice.recensioneservice.model;

import jakarta.persistence.*;
@Entity
@Table(name = "recensione")
public class Recensione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "testo")
    private String testo;

    @Column(name = "valutazione")
    private int valutazione;

    @Column(name = "idUtentePrivato")
    private String idUtentePrivato; //Utente

    public Recensione() {

    }

    public Recensione(String testo, int valutazione, String idUtentePrivato) {
        this.testo = testo;
        this.valutazione = valutazione;
        this.idUtentePrivato = idUtentePrivato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public String getIdUtentePrivato() {
        return idUtentePrivato;
    }

    public void setIdUtentePrivato(String idUtentePrivato) {
        this.idUtentePrivato = idUtentePrivato;
    }
}