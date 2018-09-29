package tn.esprit.PI.PI.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.PI.PI.services.UserServices;
import tn.esprit.PI.persistance.User;

@ManagedBean(name="UserBean")
@SessionScoped
public class UserBean {

	@EJB
	UserServices userservice;
	
	private List<User> u; 
	private List<User> lstuser;
	private User selectedUser;
	private User user = new User();
	private boolean formUserDisplay = false;
	private String login;
	private String type;
	
	@PostConstruct
	public void init() {
		u=userservice.findAllUsers();
	}
	
	public List<User> getU() {
		return u;
	}
	public void setU(List<User> u) {
		this.u = u;
	}
	
	
	public String doSearch() {
		lstuser=userservice.findUserByLogin(login);
		
		return null;
		
	}
	
//	public String doSearchRole() {
//		u=userservice.findUserByType(type);
//		return null;
//	}

	public String doCancel() {
		formUserDisplay = false;
		user = new User();
		return null;
	}
	
	public String doDelete() {
		userservice.deleteUser(user);;
		formUserDisplay = false;
		init();
		return null;
	}
	
	public boolean isFormUserDisplay() {
		return formUserDisplay;
	}
	public void setFormUserDisplay(boolean formUserDisplay) {
		this.formUserDisplay = formUserDisplay;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getSelectedUser() {
		return selectedUser;
	}
	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<User> getLstuser() {
		return lstuser;
	}

	public void setLstuser(List<User> lstuser) {
		this.lstuser = lstuser;
	}
	
	
}
