package microservice.recensioneservice.controller;

import java.util.ArrayList;
import java.util.List;
import microservice.recensioneservice.model.Recensione;
import microservice.recensioneservice.repo.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/recensione")
public class RecensioneController  {

    @Autowired
    RecensioneRepository repository;

    @GetMapping("/recensioni")
    public List<Recensione> getAllRecensione() {
        System.out.println("Get all Recensioni...");

        List<Recensione> recensioni = new ArrayList<>();
        repository.findAll().forEach(recensioni::add);

        return recensioni;
    }

}
