package microservice.bikeservice.model;

import java.util.List;

public class BikeList {
    private List<Bike> bikes;

    public BikeList(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public List<Bike> getBike() {
        return bikes;
    }

    public void setBike(List<Bike> bikes) {
        this.bikes = bikes;
    }

}
