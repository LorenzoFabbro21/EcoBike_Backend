package microservice.userservice.repo;

import microservice.userservice.model.Dealer;
import microservice.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface DealerRepository extends CrudRepository<Dealer, Long> {

}