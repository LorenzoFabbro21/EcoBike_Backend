package microservice.annuncioservice.service;

import microservice.annuncioservice.model.*;
import microservice.annuncioservice.repo.*;
import org.springframework.http.*;

import java.util.*;

public class AnnuncioVenditaServiceImpl implements AnnuncioVenditaService{
    private AnnuncioVenditaRepository repository;

    @Override
    public AnnuncioVendita saveAnnouncement(AnnuncioVendita announcement) {
        return repository.save(announcement);
    }

    @Override
    public List<AnnuncioVendita> getAllAnnouncement() {
        List<AnnuncioVendita> announcement = new ArrayList<>();
        repository.findAll().forEach(announcement::add);
        return announcement;
    }

    @Override
    public Optional<AnnuncioVendita> getAnnouncementById(long id) {
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
    public ResponseEntity<AnnuncioVendita> updateAnnouncement(long id, AnnuncioVendita announcement) {
        Optional<AnnuncioVendita> AnnouncementData = repository.findById(id);

        if (AnnouncementData.isPresent()) {
            AnnuncioVendita _announcement = AnnouncementData.get();
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
