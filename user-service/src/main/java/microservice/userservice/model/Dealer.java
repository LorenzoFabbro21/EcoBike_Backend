package microservice.userservice.model;

public class Dealer extends User{
    public Dealer() {
        super();
    }

    public Dealer(String nome, String cognome, String mail, String password, int telefono, String type) {
        super(nome, cognome, mail, password, telefono, type);
    }
}
