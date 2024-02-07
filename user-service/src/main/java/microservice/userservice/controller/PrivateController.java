package microservice.userservice.controller;

import microservice.userservice.model.Dealer;
import microservice.userservice.model.Private;
import microservice.userservice.service.DealerService;
import microservice.userservice.service.PrivateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PrivateController {
    private PrivateService privateService;

    @PostMapping(value = "/private/create")
    public Private postPrivate(@RequestBody Private user) {

        Private _Private = privateService.savePrivate(new Private(user.getNome(), user.getCognome(), user.getMail(), user.getPassword(), user.getTelefono() , user.getType()));
        return _Private;
    }

    @GetMapping("/private/{id}")
    public Private getPrivate(@PathVariable("id") long id) {
        System.out.println("Get Private...");
        Private userprivate = new Private();
        if (privateService.getPrivateById(id).isPresent()) {
            return userprivate;
        }
        else return null;
    }

    @GetMapping("/privates")
    public List<Private> getAllPrivate() {
        System.out.println("Get all Privates...");
        List<Private> userprivate = new ArrayList<>();
        privateService.getAllPrivates();
        return userprivate;
    }

    @DeleteMapping("/private/{id}")
    public ResponseEntity<String> deletePrivate(@PathVariable("id") long id) {
        System.out.println("Delete Private with ID = " + id + "...");
        ResponseEntity<String> response = privateService.deletePrivate(id);
        return response;
    }
    @DeleteMapping("/privates/delete")
    public ResponseEntity<String> deleteAllPrivates() {
        System.out.println("Delete All Privates...");

        ResponseEntity<String> response = privateService.deleteAllPrivates();

        return response;
    }

    @PutMapping("/privates/{id}")
    public ResponseEntity<Private> updatePrivates(@PathVariable("id") long id, @RequestBody Private userprivate) {
        System.out.println("Update Dealer with ID = " + id + "...");
        ResponseEntity<Private> response = privateService.updatePrivate(id, userprivate);
        return response;
    }
}
