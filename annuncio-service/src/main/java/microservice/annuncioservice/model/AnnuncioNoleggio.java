package microservice.annuncioservice.model;

public class AnnuncioNoleggio extends Annuncio {
    public AnnuncioNoleggio() {
        super();
    }

    public AnnuncioNoleggio(long id, int price, int id_bike, int id_user, String type) {
        super(id, price, id_bike, id_user, type);
    }
}
