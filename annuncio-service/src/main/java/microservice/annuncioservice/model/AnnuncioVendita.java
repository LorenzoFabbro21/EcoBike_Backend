package microservice.annuncioservice.model;

public class AnnuncioVendita extends Annuncio{
    public AnnuncioVendita() {
        super();
    }

    public AnnuncioVendita(long id, int price, int id_bike, int id_user, String type) {
        super(id, price, id_bike, id_user, type);
    }
}
