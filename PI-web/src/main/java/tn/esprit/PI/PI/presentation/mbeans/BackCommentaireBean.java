package tn.esprit.PI.PI.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PI.PI.services.CommentaireServicesLocal;
import tn.esprit.PI.persistance.User;

@ManagedBean
@SessionScoped
public class BackCommentaireBean {
	

	public BackCommentaireBean() {
		super();
	}

	@EJB
	private CommentaireServicesLocal comServices;

	
	private List<User> ActiveUsers;
	private List<User> InActiveUsers;
	
	@PostConstruct
	public void init() {
		ActiveUsers= comServices.ActiveUsers();
		InActiveUsers=comServices.inActiveUsers();
		System.out.println(ActiveUsers);
		System.out.println(InActiveUsers);
	}

	public CommentaireServicesLocal getComServices() {
		return comServices;
	}

	public void setComServices(CommentaireServicesLocal comServices) {
		this.comServices = comServices;
	}

	public List<User> getActiveUsers() {
		return ActiveUsers;
	}

	public void setActiveUsers(List<User> activeUsers) {
		ActiveUsers = activeUsers;
	}

	public List<User> getInActiveUsers() {
		return InActiveUsers;
	}

	public void setInActiveUsers(List<User> inActiveUsers) {
		InActiveUsers = inActiveUsers;
	}
	
	

	

}
