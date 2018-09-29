package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservationevent
 *
 */
@Entity
public class Reservationevent implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
	private ReservationeventPK reservationeventPK;
	private int reservationStatus;

	private int ticketsNumber;

	private double unitPrice;

	@ManyToOne
	@JoinColumn(name="id_event",referencedColumnName="idEvent",insertable=false,updatable=false)
	private Event event;
	@ManyToOne
	@JoinColumn(name="id_User",referencedColumnName="id",insertable=false,updatable=false)
	private User user;

	public Reservationevent() {
	}

	public int getReservationStatus() {
		return this.reservationStatus;
	}

	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public int getTicketsNumber() {
		return this.ticketsNumber;
	}

	public void setTicketsNumber(int ticketsNumber) {
		this.ticketsNumber = ticketsNumber;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}