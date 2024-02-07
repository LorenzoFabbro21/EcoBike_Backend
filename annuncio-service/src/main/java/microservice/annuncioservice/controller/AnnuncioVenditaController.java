package microservice.annuncioservice.controller;

import microservice.annuncioservice.model.*;
import microservice.annuncioservice.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class AnnuncioVenditaController {
    private AnnuncioVenditaService saleAnnouncementService;

    @PostMapping(value = "/saleAnnouncements/create")
    public AnnuncioVendita postAnnuncioVendita(@RequestBody AnnuncioVendita saleAannouncement) {

        AnnuncioVendita _saleAannouncement = saleAnnouncementService.saveAnnouncement(new AnnuncioVendita(saleAannouncement.getId(), saleAannouncement.getPrice(), saleAannouncement.getId_bike(), saleAannouncement.getId_user(), saleAannouncement.getType()));
        return _saleAannouncement;
    }

    @GetMapping("/saleAnnouncements/{id}")
    public AnnuncioVendita getAnnuncioVendita(@PathVariable("id") long id) {
        System.out.println("Get announcement...");
        AnnuncioVendita AnnuncioVendita = new AnnuncioVendita();
        if (saleAnnouncementService.getAnnouncementById(id).isPresent()) {
            return AnnuncioVendita;
        }
        else return null;
    }

    @GetMapping("/saleAnnouncements")
    public List<AnnuncioVendita> getAllNegozi() {
        System.out.println("Get all announcement...");
        List<AnnuncioVendita> negozi = new ArrayList<>();
        saleAnnouncementService.getAllAnnouncement();
        return negozi;
    }

    @DeleteMapping("/saleAnnouncements/{id}")
    public ResponseEntity<String> deleteAnnuncioVendita(@PathVariable("id") long id) {
        System.out.println("Delete announcement with ID = " + id + "...");
        ResponseEntity<String> response = saleAnnouncementService.deleteAnnouncement(id);
        return response;
    }
    @DeleteMapping("/saleAnnouncements/delete")
    public ResponseEntity<String> deleteAllAnnuncioVenditas() {
        System.out.println("Delete All shop...");

        ResponseEntity<String> response = saleAnnouncementService.deleteAllAnnouncements();

        return response;
    }

    @PutMapping("/saleAnnouncements/{id}")
    public ResponseEntity<AnnuncioVendita> updateAnnuncioVendita(@PathVariable("id") long id, @RequestBody AnnuncioVendita AnnuncioVendita) {
        System.out.println("Update shop with ID = " + id + "...");
        ResponseEntity<AnnuncioVendita> response = saleAnnouncementService.updateAnnouncement(id,AnnuncioVendita);
        return response;
    }
}
