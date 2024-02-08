package microservice.appointmentservice.controller;

import microservice.appointmentservice.model.Appointment;
import microservice.appointmentservice.service.AppointmentService;
import microservice.bookingservice.model.Booking;
import microservice.bookingservice.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class AppointmentController {
    private AppointmentService appointmentService;

    @PostMapping(value = "/appointment/create")
    public Appointment postAppointment(@RequestBody Appointment appointment) {
        Appointment _appointment = appointmentService.saveAppointment(new Appointment(appointment.getId(), appointment.getIdUser(), appointment.getIdAnnouncement(), appointment.getDate()));
        return _appointment;
    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointment(@PathVariable("id") long id) {
        System.out.println("Get Appointment...");
        Appointment appointment = new Appointment();
        if (appointmentService.getAppointmentById(id).isPresent())
            return appointment;
        else
            return null;
    }

    @GetMapping("/appointment")
    public List<Appointment> getAllAppointment() {
        System.out.println("Get all Appointments...");
        List<Appointment> appointments = new ArrayList<>();
        appointmentService.getAllAppointments().forEach(appointments::add);
        return appointments;
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") long id) {
        System.out.println("Delete Appointment with ID = " + id + "...");
        ResponseEntity<String> response = appointmentService.deleteAppointment(id);
        return response;
    }
    @DeleteMapping("/appointment")
    public ResponseEntity<String> deleteAllAppointments() {
        System.out.println("Delete all Appointments...");
        ResponseEntity<String> response = appointmentService.deleteAllAppointments();
        return response;
    }

    @PutMapping("/appoinment/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
        System.out.println("Update Appointment with ID = " + id + "...");
        ResponseEntity<Appointment> response = appointmentService.updateAppointment(id,appointment);
        return response;
    }
}
