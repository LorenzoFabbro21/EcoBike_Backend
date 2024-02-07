package microservice.annuncioservice.repo;

import microservice.annuncioservice.model.*;
import org.springframework.data.repository.*;

public interface AnnuncioNoleggioRepository extends CrudRepository<AnnuncioNoleggio, Long> {
}

