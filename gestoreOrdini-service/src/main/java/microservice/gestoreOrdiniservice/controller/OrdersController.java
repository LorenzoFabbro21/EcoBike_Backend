package microservice.gestoreOrdiniservice.controller;

import microservice.gestoreOrdiniservice.model.Order;
import microservice.gestoreOrdiniservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class OrdersController {
    private OrderService orderService;

    @PostMapping(value = "/order/create")
    public Order postReview(@RequestBody Order order) {
        Order _order = orderService.saveOrder(new Order(order.getId(),  order.getIdUser(), order.getPrice()));
        return _order;
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") long id) {
        System.out.println("Get order...");
        Order order = new Order();
        if (orderService.getOrderById(id).isPresent())
            return order;
        else
            return null;
    }

    @GetMapping("/order")
    public List<Order> getAllOrder() {
        System.out.println("Get all orders...");
        List<Order> orders = new ArrayList<>();
        orderService.getAllOrders();
        return orders;
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
        System.out.println("Delete Order with ID = " + id + "...");
        ResponseEntity<String> response = orderService.deleteOrder(id);
        return response;
    }
    @DeleteMapping("/order")
    public ResponseEntity<String> deleteAllOrders() {
        System.out.println("Delete all Orders...");
        ResponseEntity<String> response = orderService.deleteAllOrders();
        return response;
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
        System.out.println("Update Order with ID = " + id + "...");
        ResponseEntity<Order> response = orderService.updateOrder(id,order);
        return response;
    }
}
