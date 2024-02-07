package microservice.annuncioservice.service;

import microservice.annuncioservice.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface AnnuncioNoleggioService {

    AnnuncioNoleggio saveAnnouncement(AnnuncioNoleggio announcement);

    List<AnnuncioNoleggio> getAllAnnouncement();

    Optional<AnnuncioNoleggio> getAnnouncementById(long id);

    ResponseEntity<String> deleteAnnouncement(long id);

    ResponseEntity<String> deleteAllAnnouncements();

    ResponseEntity<AnnuncioNoleggio> updateAnnouncement( long id, @RequestBody AnnuncioNoleggio Announcement);
}
