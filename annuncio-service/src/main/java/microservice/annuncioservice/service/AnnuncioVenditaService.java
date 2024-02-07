package microservice.annuncioservice.service;

import microservice.annuncioservice.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface AnnuncioVenditaService {

    AnnuncioVendita saveAnnouncement(AnnuncioVendita announcement);

    List<AnnuncioVendita> getAllAnnouncement();

    Optional<AnnuncioVendita> getAnnouncementById(long id);

    ResponseEntity<String> deleteAnnouncement(long id);

    ResponseEntity<String> deleteAllAnnouncements();

    ResponseEntity<AnnuncioVendita> updateAnnouncement( long id, @RequestBody AnnuncioVendita Announcement);
}
