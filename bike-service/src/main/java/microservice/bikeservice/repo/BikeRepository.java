package microservice.bikeservice.repo;

import microservice.bikeservice.model.*;
import org.springframework.data.repository.CrudRepository;

public class BikeRepository extends CrudRepository<Bike, Long> {

}
