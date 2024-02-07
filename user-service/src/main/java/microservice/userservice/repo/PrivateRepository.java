package microservice.userservice.repo;

import microservice.userservice.model.Dealer;
import microservice.userservice.model.Private;
import org.springframework.data.repository.CrudRepository;

public interface PrivateRepository extends CrudRepository<Private, Long> {

}