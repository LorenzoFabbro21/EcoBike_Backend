package microservice.negozioservice.service;

import microservice.negozioservice.model.*;
import microservice.negozioservice.repo.*;
import org.springframework.http.*;

import java.util.*;
import java.util.List;
public class NegozioServiceImpl implements NegozioService{

    private NegozioRepository repository;
    @Override
    public Negozio saveShop(Negozio negozio) {
        return repository.save(negozio);
    }

    @Override
    public List<Negozio> getAllShop() {
        List<Negozio> negozi = new ArrayList<>();
        repository.findAll().forEach(negozi::add);
        return negozi;
    }

    @Override
    public Optional<Negozio> getShopById(long id) {

        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteNegozio(long id) {
        repository.deleteById(id);

        return new ResponseEntity<>("Negozio has been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllNegozi() {

        repository.deleteAll();
        return new ResponseEntity<>("All Negozios have been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Negozio> updateNegozio(long id, Negozio negozio) {
        Optional<Negozio> NegozioData = repository.findById(id);

        if (NegozioData.isPresent()) {
            Negozio _Negozio = NegozioData.get();
            _Negozio.setName(negozio.getName());
            _Negozio.setCity(negozio.getCity());
            _Negozio.setAddress(negozio.getAddress());
            _Negozio.setPhone_number(negozio.getPhone_number());
            _Negozio.setId_user(negozio.getId_user());

            repository.save(_Negozio);
            return new ResponseEntity<>(repository.save(_Negozio), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
