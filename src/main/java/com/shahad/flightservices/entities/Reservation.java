package com.shahad.flightservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;


@Entity

public class Reservation extends AbstractEntity {
	
	private Boolean checkedIn;
	 public int getNumberof_bags() {
		return numberof_bags;
	}

	public void setNumberof_bags(int numberof_bags) {
		this.numberof_bags = numberof_bags;
	}

	private int numberof_bags;
	@OneToOne
	private Flight flight;
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@OneToOne
	private Passenger passenger;



	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	
	
}
