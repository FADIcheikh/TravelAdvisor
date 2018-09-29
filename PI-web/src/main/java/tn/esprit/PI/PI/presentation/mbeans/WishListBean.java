package tn.esprit.PI.PI.presentation.mbeans;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.print.DocFlavor.STRING;
import javax.security.auth.x500.X500Principal;

import tn.esprit.PI.PI.services.UserServicesLocal;
import tn.esprit.PI.PI.services.WishListServicesLocal;
import tn.esprit.PI.persistance.Offer;
import tn.esprit.PI.persistance.Touristicplace;
import tn.esprit.PI.persistance.User;
import tn.esprit.PI.persistance.WishList;
@ApplicationScoped
@ManagedBean
public class WishListBean {
	
	@EJB
    public WishListServicesLocal ws;
	@EJB
	public UserServicesLocal us;
	   private WishList wi=new WishList();
	   private List<Touristicplace>tps= new ArrayList<Touristicplace>();

	   private List<Touristicplace>tpsOfOneWl= new ArrayList<Touristicplace>();
	   private List<WishList> wis=new ArrayList<WishList>();
	   private Touristicplace t=new Touristicplace();
	   
	  private String id;
	  private String id2;
	  private boolean dip=false;
	  private String var;
	  private Offer BestOffer;
	  
	  private User user;
	  private int var2;
	  
	  public int getVar2() {
		return var2;
	}

	public void setVar2(int var2) {
		this.var2 = var2;
	}
	private String userEmail;

	public Offer getBestOffer() {
		return BestOffer;
	}

	public void setBestOffer(Offer bestOffer) {
		BestOffer = bestOffer;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public boolean isDip() {
		return dip;
	}

	public void setDip(boolean dip) {
		this.dip = dip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public Touristicplace getT() {
		return t;
	}

	public void setT(Touristicplace t) {
		this.t = t;
	}

	public List<Touristicplace> getTps() {
		return tps;
	}

	public void setTps(List<Touristicplace> tps) {
		this.tps = tps;
	}

	public WishList getWi() {
		return wi;
	}

	public void setWi(WishList wi) {
		this.wi = wi;
	}
	
	public List<WishList> getWis() {
		return wis;
	}

	public List<Touristicplace> getTpsOfOneWl() {
		return tpsOfOneWl;
	}

	public void setTpsOfOneWl(List<Touristicplace> tpsOfOneWl) {
		this.tpsOfOneWl = tpsOfOneWl;
	}

	public void setWis(List<WishList> wis) {
		this.wis = wis;
	}
public String update2(int id) {
	var2=id;
	return  "/WishList/UpdateWL?faces-redirect=true";
}
	@PostConstruct
	  public void init(){
		
	
		  wis=ws.findAll(user);
		tps=ws.findAllTouristicPlaces();
      
        System.out.println("my list ");
        for (WishList w : wis) {
			System.out.println(w.getName());
			System.out.println("list best offers");
			/*List<Offer>l=ws.BestOffers();
			for (Offer offer : l) {
				System.out.println(offer.getNameOffer());
				
			}*/
		}
		dip=ifExiste();
	  } 
	public String Add() {
		wi.setUser(user);
		  ws.addWishList(wi);
wis=ws.findAll(user);
			return "/WishList/MyWishLists?faces-redirect=true";
	} 
	public void TpOfOneWL(WishList wi){
		tpsOfOneWl=ws.findTpOfOneWl(wi.getIdWishList());
		//return "/WishList/ListTPOfOneWL?faces-redirect=true";
		init();
	}
	public void AddTpToWL(int id){
		System.out.println("Add TouristicPlace to wish liste ===============================>id wish"+id);
		//WishList wi=ws.findById(id2);
		dip=true;
		WishList wi=new WishList();
		/*wi.setIdWishList(2);*/
		wi=this.wi;
	
		Touristicplace t1=ws.findTPById(id);
	
		
		ws.addTPToWish(t1, wi, 5);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadded");
		init();
	}
	public void Delete(int id) {
wi=ws.findById(id);
ws.delete(wi);
wis=ws.findAll(user);
System.out.println("deleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeete");
	}
	public String Details(int id) {
		
		wi=ws.findById(id);
	TpOfOneWL(wi);
	init();
		return "/WishList/AddTpToWishList?faces-redirect=true";
	}
	
	public boolean ifExiste() {
		
		for (Touristicplace touristicplace : tpsOfOneWl) {
			if (t== touristicplace){
				return true;
			}
		}
		
		return false;
	}
	
	public List<Offer> listOfOffersOfOnTP(Touristicplace t) {
	List<Offer> OL=ws.FindOffers(t);
	init();
		return OL;
	}
	
	public Number CountReservation(int id) {
		return ws.CountReservation(id);
		
	}
	
	public String ListMyWish() {
		ws.findAll(user);
		return "/WishList/MyWishLists?faces-redirect=true";
	}
	
	
	public String update() {
		wi.setUser(user);
		WishList w5=ws.findById(var2);
		ws.update(w5);
		  
init();
			return "/WishList/MyWishLists?faces-redirect=true";
	}
	public String BestOffer(Touristicplace t){
		
		
	
	
		System.out.println("list best offers");
		
		
		//Number l=ws.CountReservation(2);
		//System.out.println(l);
		List<Offer>L=ws.FindOffers(t);
		System.out.println("Offer___TP");
		Map<Integer,Number> mymap = new TreeMap<Integer,Number>();
		List<Number> listOfCounts=new ArrayList<Number>();
		for (Offer offer : L) {
			System.out.println(offer.getIdOffer()+"_______________"+offer.getDescription());
			Number k=ws.CountReservation(offer.getIdOffer());
			System.out.println("num reservations of offer number"+offer.getIdOffer()+"   ="+k);
	
			listOfCounts.add(k);
			mymap.put(offer.getIdOffer(), k);
			
		
		}	
		
		
		for (Map.Entry<Integer, Number> element : mymap.entrySet()) {
			
			System.out.println(element.getKey().toString() + " : " + element.getValue().toString());
	
			}
		//String first = mymap.firstEntry().getValue();
		
		Map.Entry<Integer, Number> entry = mymap.entrySet().iterator().next();
		System.out.println("Best Offer is "+ws.findOfferById(entry.getKey()).getNameOffer()+" it has "+entry.getValue()+"  Reservations");
		System.out.println(entry);
		System.out.println(ws.findOfferById(entry.getKey()).getNameOffer());
		entry.getKey();
	BestOffer= ws.findOfferById(entry.getKey());
	return "/WishList/BestOffer?faces-redirect=true";
	}
}
