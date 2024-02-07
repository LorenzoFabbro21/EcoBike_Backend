package microservice.annuncioservice.service;

import microservice.annuncioservice.model.*;
import microservice.annuncioservice.repo.*;
import org.springframework.http.*;

import java.util.*;

public class AnnuncioNoleggioServiceImpl implements AnnuncioNoleggioService{

    private AnnuncioNoleggioRepository repository;

    @Override
    public AnnuncioNoleggio saveAnnouncement(AnnuncioNoleggio announcement) {
        return repository.save(announcement);
    }

    @Override
    public List<AnnuncioNoleggio> getAllAnnouncement() {
        List<AnnuncioNoleggio> announcement = new ArrayList<>();
        repository.findAll().forEach(announcement::add);
        return announcement;
    }

    @Override
    public Optional<AnnuncioNoleggio> getAnnouncementById(long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteAnnouncement(long id) {
        repository.deleteById(id);

        return new ResponseEntity<>("Announcemenent has been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllAnnouncements() {
        repository.deleteAll();
        return new ResponseEntity<>("All announcemenents have been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AnnuncioNoleggio> updateAnnouncement(long id, AnnuncioNoleggio announcement) {
        Optional<AnnuncioNoleggio> AnnouncementData = repository.findById(id);

        if (AnnouncementData.isPresent()) {
            AnnuncioNoleggio _announcement = AnnouncementData.get();
            _announcement.setPrice(announcement.getPrice());
            _announcement.setId_bike(announcement.getId_bike());
            _announcement.setId_user(announcement.getId_user());

            repository.save(_announcement);
            return new ResponseEntity<>(repository.save(_announcement), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
