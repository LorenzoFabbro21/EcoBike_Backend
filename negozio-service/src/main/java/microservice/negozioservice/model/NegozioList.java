package microservice.negozioservice.model;

import java.util.List;

public class NegozioList {
    private List<Negozio> shops;

    public NegozioList(List<Negozio> shops) {
        this.shops = shops;
    }

    public List<Negozio> getshops() {
        return shops;
    }

    public void setShops(List<Negozio> orders) {
        this.shops = shops;
    }
}
