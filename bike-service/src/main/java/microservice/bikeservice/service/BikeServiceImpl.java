package microservice.bikeservice.service;

import microservice.bikeservice.model.Bike;
import microservice.bikeservice.repo.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BikeServiceImpl {

    private BikeRepository repository;

    @Override
    public Bike saveBike(Bike bike) {
        return repository.save(bike);
    }

    @Override
    public List<Bike> getAllBike() {
        List<Bike> bikes = new ArrayList<>();
        repository.findAll().forEach(bikes::add);
        return bikes;
    }

    @Override
    public Optional<Bike> getBikeById(long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteBike(long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Bike has been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllBike() {
        repository.deleteAll();
        return new ResponseEntity<>("All bikes have been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Bike> updateBike(long id, Bike bike) {
        Optional<Bike> BikeData = repository.findById(id);

        if (BikeData.isPresent()) {
            Bike _bike = BikeData.get();
            _bike.setBrand(bike.getBrand());
            _bike.setModel(bike.getModel());
            _bike.setSize(bike.getSize());
            _bike.setType(bike.getType());
            _bike.setColor(bike.getColor());
            _bike.setMeasure(bike.getMeasure());
            _bike.setImg(bike.getImg());

            repository.save(_bike);
            return new ResponseEntity<>(repository.save(_bike), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}