package microservice.gestoreOrdiniservice.model;


import java.util.List;

public class OrdersList {
    private List<Order> order;

    public OrdersList(List<Order> order) {
        this.order = order;
    }

    public List<Order> getReviews() {
        return order;
    }

    public void setReviews(List<Order> reviews) {
        this.order = order;
    }
}
