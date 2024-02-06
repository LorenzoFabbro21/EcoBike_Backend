package microservice.negozioservice.service;

import microservice.negozioservice.model.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public interface NegozioService {
    Negozio saveShop(Negozio negozio);

    List<Negozio> getAllShop();

    Optional<Negozio> getShopById(long id);

    ResponseEntity<String> deleteNegozio(long id);

    ResponseEntity<String> deleteAllNegozi();

    ResponseEntity<Negozio> updateNegozio( long id, @RequestBody Negozio negozio);
}
