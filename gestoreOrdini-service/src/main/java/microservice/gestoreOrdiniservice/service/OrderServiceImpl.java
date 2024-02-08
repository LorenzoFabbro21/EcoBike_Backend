package microservice.gestoreOrdiniservice.service;

import microservice.gestoreOrdiniservice.model.Order;
import microservice.gestoreOrdiniservice.repo.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService{

    public OrderRepository repository;

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        repository.findAll().forEach(orders::add);
        return orders;
    }

    @Override
    public Optional<Order> getOrderById(long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteOrder(long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Order has been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllOrders() {
        repository.deleteAll();
        return new ResponseEntity<>("All orders have been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Order> updateOrder(long id, Order order) {
        Optional<Order> OrderData = repository.findById(id);

        if (OrderData.isPresent()) {
            Order _order = OrderData.get();
            _order.setPrice(order.getPrice());
            _order.setIdUser(order.getIdUser());
            repository.save(_order);
            return new ResponseEntity<>(repository.save(_order), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
