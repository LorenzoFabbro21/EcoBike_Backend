package microservice.gestoreOrdiniservice.service;

import microservice.gestoreOrdiniservice.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order saveOrder(Order order);

    List<Order> getAllOrders();

    Optional<Order> getOrderById(long id);

    ResponseEntity<String> deleteOrder(long id);

    ResponseEntity<String> deleteAllOrders();

    ResponseEntity<Order> updateOrder(long id, @RequestBody Order order);
}
