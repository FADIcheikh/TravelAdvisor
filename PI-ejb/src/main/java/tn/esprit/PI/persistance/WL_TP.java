package tn.esprit.PI.persistance;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: WL_TP
 *
 */
@Entity

public class WL_TP implements Serializable {

	   
	@EmbeddedId
	private WL_TPId WL_TPId;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "TouristicplaceId", referencedColumnName = "idTouristicPlaces", updatable = false, insertable = false)
	Touristicplace touristicplace ;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "WishListId", referencedColumnName = "IdWishList", updatable = false, insertable = false)
	WishList wishList ;
	private int importance;

	private static final long serialVersionUID = 1L;

	public WL_TP() {
		super();
	}  
	
	

	public WL_TP(WL_TPId wL_TPId, Touristicplace touristicplace, WishList wishList,
			int importance) {
		super();
		WL_TPId = wL_TPId;
		this.touristicplace = touristicplace;
		this.wishList = wishList;
		this.importance = importance;
	}



	public Touristicplace getTouristicplace() {
		return touristicplace;
	}

	public void setTouristicplace(Touristicplace touristicplace) {
		touristicplace = touristicplace;
	}

	public WishList getWishList() {
		return wishList;
	}

	public void setWishList(WishList wishList) {
		wishList = wishList;
	}

	public WL_TPId getWL_TPId() {
		return WL_TPId;
	}

	public void setWL_TPId(WL_TPId wL_TPId) {
		WL_TPId = wL_TPId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((WL_TPId == null) ? 0 : WL_TPId.hashCode());
		result = prime * result + ((wishList == null) ? 0 : wishList.hashCode());
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
		WL_TP other = (WL_TP) obj;
		if (WL_TPId == null) {
			if (other.WL_TPId != null)
				return false;
		} else if (!WL_TPId.equals(other.WL_TPId))
			return false;
		if (wishList == null) {
			if (other.wishList != null)
				return false;
		} else if (!wishList.equals(other.wishList))
			return false;
		return true;
	}

}	
