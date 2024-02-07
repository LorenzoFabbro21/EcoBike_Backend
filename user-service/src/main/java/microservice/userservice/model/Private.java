package microservice.userservice.model;

public class Private extends User{
    public Private() {
        super();
    }

    public Private(String nome, String cognome, String mail, String password, int telefono, String type) {
        super(nome, cognome, mail, password, telefono, type);
    }
}
