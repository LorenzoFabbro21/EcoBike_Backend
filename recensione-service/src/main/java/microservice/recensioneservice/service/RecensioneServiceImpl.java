package microservice.recensioneservice.service;

import microservice.recensioneservice.model.Recensione;
import microservice.recensioneservice.repo.RecensioneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.sound.sampled.ReverbType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecensioneServiceImpl implements RecensioneService {

    private RecensioneRepository repository;

    @Override
    public Recensione saveReview(Recensione review) {
        return repository.save(review);
    }

    @Override
    public List<Recensione> getAllReview() {
        List<Recensione> reviews = new ArrayList<>();
        repository.findAll().forEach(reviews::add);
        return reviews;
    }

    @Override
    public Optional<Recensione> getReviewById(long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteReview(long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Review has been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllReview() {
        repository.deleteAll();
        return new ResponseEntity<>("All reviews have been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Recensione> updateReview(long id, Recensione review) {
        Optional<Recensione> ReviewData = repository.findById(id);

        if (ReviewData.isPresent()) {
            Recensione _review = ReviewData.get();
            _review.setText(review.getText());
            _review.setScore(review.getScore());
            _review.setIdUser(review.getIdUser());
            repository.save(_review);
            return new ResponseEntity<>(repository.save(_review), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}