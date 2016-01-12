package myproject.data;

import java.util.List;

import myproject.exception.UnknownUserException;
import myproject.exception.UserAlreadyExistsException;
import myproject.model.User;

public interface UserDataAccess {
	
	public User findUser(String username) throws UnknownUserException;
	
	public List<User> getAllUser();
	
	public void createUser(User newUser) throws UserAlreadyExistsException;
	
	public void updateUser(User user) throws UnknownUserException;
	
	public void removeUser(String username) throws UnknownUserException;

}
