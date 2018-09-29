package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: WL_TPId
 *
 */
@Embeddable
public class WL_TPId implements Serializable {

	private int TouristicplaceId; 
	private int WishListId;
	
	private static final long serialVersionUID = 1L;

	public WL_TPId() {
		super();
	}

	public WL_TPId(int touristicplaceId, int wishListId) {
		super();
		TouristicplaceId = touristicplaceId;
		WishListId = wishListId;
	}

	public int getTouristicplaceId() {
		return TouristicplaceId;
	}

	public void setTouristicplaceId(int touristicplaceId) {
		TouristicplaceId = touristicplaceId;
	}

	public int getWishListId() {
		return WishListId;
	}

	public void setWishListId(int wishListId) {
		WishListId = wishListId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TouristicplaceId;
		result = prime * result + WishListId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WL_TPId other = (WL_TPId) obj;
		if (TouristicplaceId != other.TouristicplaceId)
			return false;
		if (WishListId != other.WishListId)
			return false;
		return true;
	}
   
}
