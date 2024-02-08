package microservice.appointmentservice.service;

import microservice.appointmentservice.model.Appointment;
import microservice.appointmentservice.repo.AppointmentRepository;
import microservice.bookingservice.model.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentServiceImpl implements AppointmentService {

    AppointmentRepository repository;
    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        return null;
    }

    @Override
    public Optional<Appointment> getAppointmentById(long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<String> deleteAppointment(long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("announcement has been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllAppointments() {
        repository.deleteAll();
        return new ResponseEntity<>("All announcement have been deleted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Appointment> updateAppointment(long id, Appointment appointment) {
        Optional<Appointment> AppointmentData = repository.findById(id);

        if (AppointmentData.isPresent()) {
            Appointment _appointment = AppointmentData.get();
            _appointment.setDate(appointment.getDate());
            repository.save(_appointment);
            return new ResponseEntity<>(repository.save(_appointment), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
