package tn.esprit.PI.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: WishList
 *
 */
@Entity
@Table(name="WishList")
public class WishList implements Serializable {

	   
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdWishList;
	private String Name;
	
	@OneToMany(mappedBy="wishList",cascade=CascadeType.ALL)
	private List<WL_TP> ListWT; 
	@ManyToOne
	private User user;
	private static final long serialVersionUID = 1L;
	private String Image;
	public String getImage() {
			return Image;
		}

		public void setImage(String image) {
			Image = image;
		}
	public WishList() {
		super();
	}   
	public int getIdWishList() {
		return this.IdWishList;
	}

	public void setIdWishList(int IdWishList) {
		this.IdWishList = IdWishList;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	
	public WishList(int idWishList, String name) {
		super();
		IdWishList = idWishList;
		Name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<WL_TP> getListWT() {
		return ListWT;
	}
	public void setListWT(List<WL_TP> listWT) {
		ListWT = listWT;
	}
	 
	


/*public void AffectToWishList(List<Touristicplace> tp) {
	for (Touristicplace touristicplace : tp) {
		touristicplace.setWishList(this);
	}
	this.setTouristicplaces(tp);
}*/
}
