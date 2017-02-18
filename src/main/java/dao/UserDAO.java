package dao;

import java.util.List;
import model.User;

public class UserDAO extends DAO<User>{
	@Override
	public User getById(String id){
		User user = null;
		try{
			user = entityManager.find(User.class, id);		
		}catch(Exception e){
			System.out.println("User getById Error : "+e);
		}
		return user;
	}
	
	@Override
	public boolean removeById(String id){
		User user = null;
		try{
			user = this.getById(id);
			entityManager.remove(user);
			return true;
		}catch(Exception e){
			System.out.println("USer removeById Error: "+e);
		}
		return false;
	}
	
	public List<User> getAll(){
		return entityManager.createQuery("select u from User u").getResultList();
	}
}
