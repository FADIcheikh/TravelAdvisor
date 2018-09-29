package tn.esprit.PI.PI.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.PI.PI.services.UserServicesLocal;
import tn.esprit.PI.persistance.User;





@ManagedBean(name = "authB")
@SessionScoped
public class AuthentificationBean {

	
	@EJB
	private UserServicesLocal userServiceLocal;
	private boolean loggedIn = false;
	private Boolean loggedInAsProUser = false;
	private Boolean loggedInAsSimpleUser = false;
	private Boolean loggedInAsAdmin = false;
	private User user = new User();
	
	
	public String doLogin() {
		String nav = "";
		User found = userServiceLocal.authenticate(user.getLogin(), user.getPassword());
		if (found != null) {
			user = found;
			loggedIn = true;
			if(user.getType().equalsIgnoreCase("Admin")){
				loggedInAsAdmin = true;
				nav = "/DashAdmin/Home?faces-redirect=true";
			}
			else{
				this.setUser(found); 
				System.out.println("user = "+user.getFullName());
				loggedInAsProUser = true;
				loggedInAsSimpleUser = true;
				
				nav = "/template/Home?faces-redirect=true";
			}
			
		}
		FacesMessage msg = new FacesMessage("bad credentials!");
		FacesContext.getCurrentInstance().addMessage("form_login:form_submit", msg);
		return nav;
	}

	public String doLogout() {
		String nav = "";
		loggedIn = false;
		user = new User();
		nav = "/DashAdmin/loginn?faces-redirect=true";
		return nav;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Boolean getLoggedInAsProUser() {
		return loggedInAsProUser;
	}

	public void setLoggedInAsProUser(Boolean loggedInAsProUser) {
		this.loggedInAsProUser = loggedInAsProUser;
	}

	public Boolean getLoggedInAsSimpleUser() {
		return loggedInAsSimpleUser;
	}

	public void setLoggedInAsSimpleUser(Boolean loggedInAsSimpleUser) {
		this.loggedInAsSimpleUser = loggedInAsSimpleUser;
	}

	public Boolean getLoggedInAsAdmin() {
		return loggedInAsAdmin;
	}

	public void setLoggedInAsAdmin(Boolean loggedInAsAdmin) {
		this.loggedInAsAdmin = loggedInAsAdmin;
	}
	
	
}
