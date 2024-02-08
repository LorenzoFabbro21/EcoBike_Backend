package microservice.gestoreOrdiniservice.repo;

import microservice.gestoreOrdiniservice.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
