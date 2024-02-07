package microservice.userservice.repo;

import microservice.userservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    //list<User> findAll();
}