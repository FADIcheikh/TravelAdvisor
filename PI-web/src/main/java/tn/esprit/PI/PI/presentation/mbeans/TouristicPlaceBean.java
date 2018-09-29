package tn.esprit.PI.PI.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.net.ssl.TrustManager;

import tn.esprit.PI.persistance.Offer;
import tn.esprit.PI.persistance.SSLTool;
import tn.esprit.PI.persistance.Touristicplace;
import tn.esprit.PI.PI.services.TouristicPlaceService;
import tn.esprit.PI.PI.util.MessageUtil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@ManagedBean
@SessionScoped
public class TouristicPlaceBean {
	@EJB
	TouristicPlaceService touristicServ;

	private List<Touristicplace> touristicplaceList = new ArrayList<Touristicplace>();
	private Touristicplace touristicplace = new Touristicplace();
	private List<Touristicplace> touristicplacess;
	private boolean displayForm = false;
	private String name;
	private List<Offer> offers = new ArrayList<>();

	@PostConstruct
	public void init() {

		touristicplaceList = touristicServ.findAllTouristicplace();
	}

	public String showOffer() {
		try {
			SSLTool.disableCertificateValidation();
			Client client = Client.create();
			WebResource webResource = client.resource("https://localhost:44300/api/OfferApi");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String output = response.getEntity(String.class);

			
			ObjectMapper mapper = new ObjectMapper();
			
			String[] values = mapper.readValue(output, String[].class);
			for(String val:values) {
				if(!"}".equals(val) && !"{".equals(val) && !"nameOffer".equals(val)) {
					offers.add(new Offer(val));
				}
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "consomation";
		
		
		
	}

	
	
	
	
	
	public TouristicPlaceService getTouristicServ() {
		return touristicServ;
	}

	public void setTouristicServ(TouristicPlaceService touristicServ) {
		this.touristicServ = touristicServ;
	}

	public List<Touristicplace> getTouristicplacess() {
		return touristicplacess;
	}

	public void setTouristicplacess(List<Touristicplace> touristicplacess) {
		this.touristicplacess = touristicplacess;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Touristicplace> getTouristicplaceList() {
		return touristicplaceList;
	}

	public void setTouristicplaceList(List<Touristicplace> touristicplaceList) {
		this.touristicplaceList = touristicplaceList;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offres) {
		this.offers = offers;
	}

	public Touristicplace getTouristicplace() {
		return touristicplace;
	}

	public void setTouristicplace(Touristicplace touristicplace) {
		this.touristicplace = touristicplace;
	}

	/**
	 * This function loads the customers.
	 */
	public void loadTouristicplaces() {
		this.touristicplaceList = touristicServ.findAllTouristicplace();
	}

	public void findTouristicplace() {
		this.touristicplace = touristicServ.findTouristicplaceById(this.touristicplace.getIdTouristicPlaces());

	}

	/**
	 * Clears the current customer bean
	 */
	public void clearTouristicplaces() {
		this.touristicplace = new Touristicplace();
	}

	public String deleteTouristicplace(Touristicplace touristicplace) {

		try {
			touristicServ.removeTouristicPlace(touristicplace.getIdTouristicPlaces());
			// MessageUtil.addSuccessMessage("Post was successfully deleted.");
		} catch (Exception e) {
			//MessageUtil.addErrorMessage("Could not delete Touristicplace.");
		}
		init();
		return "index";
	}

	/**
	 * 
	 * @return index to navigate to index.xhtml page
	 */
	public String createTouristicplace() {
		try {

			this.touristicplace.setTouristicPlaceImage();
			this.touristicplace.setTouristicPlaceImageLink();
			touristicServ.addTouristicPlace(this.touristicplace);
			// MessageUtil.addSuccessMessage("Post was successfully created.");
		} catch (Exception e) {
			e.printStackTrace();
			// MessageUtil.addErrorMessage("Post could not be saved. A
			// Persisting error occured.");
		}
		init();
		return "index";
	}

	/**
	 * 
	 * @return view to navigate to view.xhtml page
	 */
	public String updateTouristicplace() {
		try {
			this.touristicplace.setTouristicPlaceImage();
			this.touristicplace.setTouristicPlaceImageLink();
			touristicServ.updateTouristicplace(this.touristicplace);
			// MessageUtil.addSuccessMessage("touristicplace with id " +
			// this.touristicplace.getIdTouristicPlaces()
			// + " was successfully updated.");

		} catch (Exception e) {
			//MessageUtil.addErrorMessage("touristicplace with id " + this.touristicplace.getIdTouristicPlaces()
					//+ " could not be saved. An update error occured.");
			e.printStackTrace();
		}
		init();
		return "view";
	}

	public String mostTouristicPlace() {
		touristicplaceList = new ArrayList<>();
		touristicplaceList.add(touristicServ.allTouristicPlaceOrderWithGretherOffre().get(0));

		return "mosttouristicplace";
	}

	public String findName() {
		displayForm = false;
		touristicplaceList = touristicServ.findTouristicplaceByName(name);
		return "index";

	}

}
