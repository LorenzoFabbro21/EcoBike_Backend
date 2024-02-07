package microservice.annuncioservice.controller;

import microservice.annuncioservice.model.*;
import microservice.annuncioservice.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AnnuncioNoleggioController {
    private AnnuncioNoleggioService rentalAnnouncementService;

    @PostMapping(value = "/rentalAnnouncements/create")
    public AnnuncioNoleggio postAnnuncioNoleggio(@RequestBody AnnuncioNoleggio rentalAannouncement) {

        AnnuncioNoleggio _rentalAannouncement = rentalAnnouncementService.saveAnnouncement(new AnnuncioNoleggio(rentalAannouncement.getId(), rentalAannouncement.getPrice(), rentalAannouncement.getId_bike(), rentalAannouncement.getId_user(), rentalAannouncement.getType()));
        return _rentalAannouncement;
    }

    @GetMapping("/rentalAnnouncements/{id}")
    public AnnuncioNoleggio getAnnuncioNoleggio(@PathVariable("id") long id) {
        System.out.println("Get announcement...");
        AnnuncioNoleggio AnnuncioNoleggio = new AnnuncioNoleggio();
        if (rentalAnnouncementService.getAnnouncementById(id).isPresent()) {
            return AnnuncioNoleggio;
        }
        else return null;
    }

    @GetMapping("/rentalAnnouncements")
    public List<AnnuncioNoleggio> getAllNegozi() {
        System.out.println("Get all announcement...");
        List<AnnuncioNoleggio> negozi = new ArrayList<>();
        rentalAnnouncementService.getAllAnnouncement();
        return negozi;
    }

    @DeleteMapping("/rentalAnnouncements/{id}")
    public ResponseEntity<String> deleteAnnuncioNoleggio(@PathVariable("id") long id) {
        System.out.println("Delete announcement with ID = " + id + "...");
        ResponseEntity<String> response = rentalAnnouncementService.deleteAnnouncement(id);
        return response;
    }
    @DeleteMapping("/rentalAnnouncements/delete")
    public ResponseEntity<String> deleteAllAnnuncioNoleggios() {
        System.out.println("Delete All shop...");

        ResponseEntity<String> response = rentalAnnouncementService.deleteAllAnnouncements();

        return response;
    }

    @PutMapping("/rentalAnnouncements/{id}")
    public ResponseEntity<AnnuncioNoleggio> updateAnnuncioNoleggio(@PathVariable("id") long id, @RequestBody AnnuncioNoleggio AnnuncioNoleggio) {
        System.out.println("Update shop with ID = " + id + "...");
        ResponseEntity<AnnuncioNoleggio> response = rentalAnnouncementService.updateAnnouncement(id,AnnuncioNoleggio);
        return response;
    }
}
