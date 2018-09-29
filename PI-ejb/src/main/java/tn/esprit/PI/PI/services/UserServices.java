package tn.esprit.PI.PI.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PI.persistance.ProUser;
import tn.esprit.PI.persistance.SimpleUser;
import tn.esprit.PI.persistance.User;


/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote, UserServicesLocal {

    /**
     * Default constructor. 
     */
    public UserServices() {
        
    }
    
    @PersistenceContext
	private EntityManager em;
    User u;
    
    
    @Override
	public void addUser(User user) {
		
		em.persist(user);
	}
    
    @Override
	public void deleteUser(User user) {
		
		em.remove(em.merge(user));
	}
    
    @Override
    public void saveProUser(ProUser prouser) {
		em.merge(prouser);
	}
    
    @Override
    public void saveProUser(SimpleUser simpleuser) {
		em.merge(simpleuser);
	}
    
    
    public String getFullName(){
		return this.u.getFirstName() + " " + this.u.getLastName();
	}
    
    @Override
	public List<User> findAllUsers() {
		
		String requete = "select u from User u";
		return em.createQuery(requete, User.class).getResultList();
	}
    
    @Override
    public User authenticate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.login=:login and u.password=:password";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			found = query.getSingleResult();
		} catch (Exception ex) {
			Logger.getLogger(UserServices.class.getName()).log(
					Level.WARNING,"Your authentication attempt faill with this login=" + login+ " and this password=" + password);
		}
		return found;
	}
    
    
//    @Override
//	public User login(String login, String password) {
//		Object user = null;
//		User au = null;
//		TypedQuery<Aspnetuser> query = em.createQuery("select c from User c where c.login=:param1 and c.password=:param2", User.class);
//		query.setParameter("param1", login);
//		query.setParameter("param2", password);
//		try{
//			au = query.getSingleResult();
//		}catch(NoResultException ex){
//			System.out.println("access denied");
//		}
//		if (au != null) {
//			try{
//				user = em.createQuery("select u from User u where u.au=:param1", User.class).setParameter("param1", au).getSingleResult();
//				
//			}catch(NoResultException ex){
//				System.out.println("not admin");
//			}
//			if (user == null) {
//				try{
//					user = em.createQuery("select u from User u where u.au=:param1", Object.class).setParameter("param1", au).getSingleResult();
//					
//				}catch(NoResultException ex){
//					System.out.println("problem...");
//				}
//			}
//		}
//		return user;
//	}
    
    
    @Override
    public List<User> findUserByLogin(String login) {
		
		String jpql = "select u from User u where u.login=:login";
		return em.createQuery(jpql, User.class).setParameter("login", login).getResultList();
	}
    
    @Override
    public boolean loginExists(String login) {
		boolean exists = false;
		String jpql = "select case when (count(u) > 0)  then true else false end from User u where u.login=:login";
		TypedQuery<Boolean> query = em.createQuery(jpql, Boolean.class);
		query.setParameter("login", login);
		try {
			exists = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getLogger(UserServices.class.getName()).log(Level.WARNING,
					"There is no user registred with this login=" + login);
		}
		return exists;
	}
    
//	@Override
//	public List<User> findUserByType(String type) {
//		String jpql = "select u from User u where u.type=:type";
//		return em.createQuery(jpql, User.class).setParameter("type", type).getResultList();
//		
//	}
	
	@Override
	public Long countUsers(String idU) {
		Long UserCount = 0L;
		TypedQuery<Long> query = em.createQuery("select count(c) from User c where c.id.idU=:param1" ,Long.class);
		query.setParameter("param1", idU);
		try{
			UserCount = query.getSingleResult();
		}catch(NoResultException ex){
			System.out.println("No user exists ");
		}
		return UserCount;
	}

    
	@Override
	public User bestUser() {
		List<User> users = em.createQuery("SELECT u FROM User u ", User.class).getResultList();
		int max=0;
		User bestUser = new User();
		for (User user : users) {
			int count =0;
		int rec = (int) em.createQuery("SELECT count(d.UserId) FROM User u Join u.Cmmentaire d where u.id=?1 " ).setParameter(1,user.getId())
				.getSingleResult();
		
		count = rec ;
		if (count>max){
			max=count;
			bestUser=user;
		}
		}
		return bestUser;
	}
	@Override
	public User findUserByid(int id) {
		return em.find(User.class, id);
	}

}
