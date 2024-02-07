package microservice.bikeservice.controller;

import microservice.bikeservice.model.*;
import microservice.bikeservice.service.BikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BikeController {

    private BikeService bikeService;

    @PostMapping(value = "/bike/create")
    public Bike postBike(@RequestBody Bike bike) {
        Bike _bike = bikeService.saveBike(new Bike(bike.getId(), bike.getBrand(), bike.getModel(), bike.getSize(), bike.getType(), bike.getColor(), bike.getMeasure() ,bike.getImg()));
        return _bike;
    }

    @GetMapping("/bike/{id}")
    public Bike getBike(@PathVariable("id") long id) {
        System.out.println("Get bike...");
        Bike bike = new Bike();
        if (bikeService.getBikeById(id).isPresent()) {
            return bike;
        }
        else
            return null;
    }

    @GetMapping("/bike")
    public List<Bike> getAllBike() {
        System.out.println("Get all bike...");
        List<Bike> bikes = new ArrayList<>();
        bikeService.getAllBike();
        return bikes;
    }

    @DeleteMapping("/bike/{id}")
    public ResponseEntity<String> deleteBike(@PathVariable("id") long id) {
        System.out.println("Delete bike with ID = " + id + "...");
        ResponseEntity<String> response = bikeService.deleteBike(id);
        return response;
    }
    @DeleteMapping("/bike/delete")
    public ResponseEntity<String> deleteAllBike() {
        System.out.println("Delete all bike...");
        ResponseEntity<String> response = bikeService.deleteAllBike();
        return response;
    }

    @PutMapping("/bike/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable("id") long id, @RequestBody Bike bike) {
        System.out.println("Update bike with ID = " + id + "...");
        ResponseEntity<Bike> response = bikeService.updateBike(id, bike);
        return response;
    }
}