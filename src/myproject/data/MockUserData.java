package myproject.data;

import java.util.LinkedList;
import java.util.List;

import myproject.exception.UnknownUserException;
import myproject.exception.UserAlreadyExistsException;
import myproject.model.User;

public class MockUserData implements UserDataAccess{

	List<User> utilisateurs = new LinkedList<User>();

	public MockUserData() {
		// Jeu d'essai
		utilisateurs.add(new User("Robert", "licorne42"));
		utilisateurs.add(new User("Paul", "licorne43"));
		utilisateurs.add(new User("Jean", "licorne44"));
	}

	public User findUser(String username) throws UnknownUserException {

		for (User u : utilisateurs) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}

		throw new UnknownUserException();

	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(User newUser) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) throws UnknownUserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(String username) throws UnknownUserException {
		// TODO Auto-generated method stub
		
	}
	
	
}
