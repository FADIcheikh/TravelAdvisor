package tn.esprit.PI.PI.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.PI.persistance.ProUser;
import tn.esprit.PI.persistance.SimpleUser;
import tn.esprit.PI.persistance.User;


@Remote
public interface UserServicesRemote {

	void addUser(User user);
	
	void deleteUser(User user);
	
	void saveProUser(ProUser prouser);
	
	void saveProUser(SimpleUser simpleuser);
	
	List<User> findAllUsers();
	
	List<User> findUserByLogin(String login);
	 
//	List<User> findUserByType(String type);
	
	User authenticate(String login, String password);
	
	//User login(String login, String password);
	
	boolean loginExists(String login);
	
	Long countUsers(String idU);
	
	

}
