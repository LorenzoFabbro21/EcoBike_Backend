package microservice.recensioneservice.repo;

import microservice.recensioneservice.model.Recensione;
import org.springframework.data.repository.CrudRepository;
public interface RecensioneRepository extends CrudRepository<Recensione, Long>{

    //List<Recensione> findAll();
}
