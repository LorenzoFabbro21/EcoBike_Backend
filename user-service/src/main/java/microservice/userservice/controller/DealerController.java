package microservice.userservice.controller;

import microservice.userservice.model.Dealer;
import microservice.userservice.service.DealerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class DealerController {

    private DealerService dealerService;

    @PostMapping(value = "/dealer/create")
    public Dealer postDealer(@RequestBody Dealer dealer) {

        Dealer _Dealer = dealerService.saveDealer(new Dealer(dealer.getNome(), dealer.getCognome(), dealer.getMail(), dealer.getPassword(), dealer.getTelefono(), dealer.getType()));
        return _Dealer;
    }

    @GetMapping("/dealer/{id}")
    public Dealer getDealer(@PathVariable("id") long id) {
        System.out.println("Get dealer...");
        Dealer dealer = new Dealer();
        if (dealerService.getDealerById(id).isPresent()) {
            return dealer;
        }
        else return null;
    }

    @GetMapping("/dealers")
    public List<Dealer> getAllDealer() {
        System.out.println("Get all dealers...");
        List<Dealer> dealer = new ArrayList<>();
        dealerService.getAllDealers();
        return dealer;
    }

    @DeleteMapping("/dealer/{id}")
    public ResponseEntity<String> deleteDealer(@PathVariable("id") long id) {
        System.out.println("Delete Dealer with ID = " + id + "...");
        ResponseEntity<String> response = dealerService.deleteDealer(id);
        return response;
    }
    @DeleteMapping("/dealers/delete")
    public ResponseEntity<String> deleteAllDealers() {
        System.out.println("Delete All Dealers...");

        ResponseEntity<String> response = dealerService.deleteAllDealers();

        return response;
    }

    @PutMapping("/dealers/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable("id") long id, @RequestBody Dealer dealer) {
        System.out.println("Update Dealer with ID = " + id + "...");
        ResponseEntity<Dealer> response = dealerService.updateDealer(id, dealer);
        return response;
    }
}




