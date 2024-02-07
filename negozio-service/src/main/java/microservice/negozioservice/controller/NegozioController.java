package microservice.negozioservice.controller;

import microservice.negozioservice.model.*;
import microservice.negozioservice.repo.*;
import microservice.negozioservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class NegozioController {

    private NegozioService negozioService;

    @PostMapping(value = "/negozi/create")
    public Negozio postNegozio(@RequestBody Negozio negozio) {

        Negozio _Negozio = negozioService.saveShop(new Negozio(negozio.getId(), negozio.getName(), negozio.getCity(), negozio.getAddress(), negozio.getPhone_number(), negozio.getId_user()));
        return _Negozio;
    }

    @GetMapping("/negozi/{id}")
    public Negozio getNegozio(@PathVariable("id") long id) {
        System.out.println("Get shop...");
        Negozio negozio = new Negozio();
        if (negozioService.getShopById(id).isPresent()) {
            return negozio;
        }
        else return null;
    }

    @GetMapping("/negozi")
    public List<Negozio> getAllNegozi() {
        System.out.println("Get all shop...");
        List<Negozio> negozi = new ArrayList<>();
        negozioService.getAllShop();
        return negozi;
    }

    @DeleteMapping("/negozi/{id}")
    public ResponseEntity<String> deleteNegozio(@PathVariable("id") long id) {
        System.out.println("Delete Negozio with ID = " + id + "...");
        ResponseEntity<String> response = negozioService.deleteNegozio(id);
        return response;
    }
    @DeleteMapping("/negozi/delete")
    public ResponseEntity<String> deleteAllNegozios() {
        System.out.println("Delete All shop...");

        ResponseEntity<String> response = negozioService.deleteAllNegozi();

        return response;
    }

    @PutMapping("/negozi/{id}")
    public ResponseEntity<Negozio> updateNegozio(@PathVariable("id") long id, @RequestBody Negozio negozio) {
        System.out.println("Update shop with ID = " + id + "...");
        ResponseEntity<Negozio> response = negozioService.updateNegozio(id,negozio);
        return response;
    }

}




