package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservationoffer
 *
 */
@Entity
public class Reservationoffer implements Serializable {
	private static final long serialVersionUID = 1L;
    @EmbeddedId
	private ReservationofferPK reservationofferPK;

	private int reservationStatus;

	private int ticketsNumber;

	private double unitPrice;

	@ManyToOne
	@JoinColumn(name="id_offer",referencedColumnName="IdOffer",insertable=false,updatable=false)
	private Offer offer;
	@ManyToOne
	@JoinColumn(name="id_User",referencedColumnName="id",insertable=false,updatable=false)
	private User user;

	public Reservationoffer() {
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


	public ReservationofferPK getReservationofferPK() {
		return reservationofferPK;
	}


	public void setReservationofferPK(ReservationofferPK reservationofferPK) {
		this.reservationofferPK = reservationofferPK;
	}


	public Offer getOffer() {
		return offer;
	}


	public void setOffer(Offer offer) {
		this.offer = offer;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}