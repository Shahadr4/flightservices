package com.shahad.flightservices.integrstion;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.shahad.flightservices.dto.CreateReservationRequest;
import com.shahad.flightservices.dto.UpdateReservationRequest;
import com.shahad.flightservices.entities.Flight;

import com.shahad.flightservices.entities.Passenger;
import com.shahad.flightservices.entities.Reservation;
import com.shahad.flightservices.repos.FlightRepository;
import com.shahad.flightservices.repos.PassengerRepository;
import com.shahad.flightservices.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepositry;
	@Autowired
	ReservationRepository reservationRepository;
	
	@RequestMapping("/flight")
	public List<Flight> findFlight(@RequestParam("from") String from,@RequestParam("to") String to,@RequestParam("departureDate")@DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate) {
		return flightRepository.findFlights(from,to,departureDate);
		
	}
	@RequestMapping("/flight/{id}")
	public Flight findFlight(@PathVariable("id") int id) {
		return flightRepository.findById(id).get();
	}
	
	
	
	
	@RequestMapping(value = "/reservations",method = RequestMethod.POST)
	@Transactional
	public Reservation saveReservation(@RequestBody CreateReservationRequest request) {
		System.out.println("Save Reservation" + request.getFlightId());
		
		Flight flight = flightRepository.findById(request.getFlightId()).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		
		Passenger savedPassenger = passengerRepositry.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		
	return reservationRepository.save(reservation);
	
	
		
		
		
		
	}
	@RequestMapping(value="/reservations/{id}")
	public Reservation finfReservation(@PathVariable("id")int id) {
		return reservationRepository.findById(id).get();
		
	}
	@RequestMapping(value = "/reservations",method = RequestMethod.PUT)
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberof_bags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckIn());
		
		return reservationRepository.save(reservation);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
