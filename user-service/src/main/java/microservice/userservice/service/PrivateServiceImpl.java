package microservice.userservice.service;

import microservice.userservice.model.Dealer;
import microservice.userservice.model.Private;
import microservice.userservice.repo.DealerRepository;
import microservice.userservice.repo.PrivateRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrivateServiceImpl implements PrivateService {

    PrivateRepository repository;

    @Override
    public Private savePrivate(Private user) {
        return repository.save(user);
    }

    @Override
    public List<Private> getAllPrivates() {
        List<Private> privates = new ArrayList<>();
        repository.findAll().forEach(privates::add);
        return privates;
    }

    @Override
    public Optional<Private> getPrivateById(long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> deletePrivate(long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Private has been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllPrivates() {
       repository.deleteAll();
       return new ResponseEntity<>("All Privates have been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Private> updatePrivate(long id, Private userprivate) {
        Optional<Private> privatedata = repository.findById(id);

        if(privatedata.isPresent()) {
            Private Private = privatedata.get();
            Private.setNome(userprivate.getNome());
            Private.setCognome(userprivate.getCognome());
            Private.setMail(userprivate.getMail());
            Private.setPassword(userprivate.getPassword());
            Private.setTelefono(userprivate.getTelefono());
            Private.setType((userprivate.getType()));
            repository.save(Private);
            return new ResponseEntity<>(repository.save(Private), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
