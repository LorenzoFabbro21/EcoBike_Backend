package microservice.negozioservice.repo;

import microservice.negozioservice.model.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface NegozioRepository extends CrudRepository<Negozio, Long> {

}
