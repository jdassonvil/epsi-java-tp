package myproject.data;

import java.util.List;

import myproject.exception.DataAccessException;
import myproject.exception.UnknownUserException;
import myproject.exception.UserAlreadyExistsException;
import myproject.model.User;

public interface UserDataAccess {
	
	public User findUser(String username) throws UnknownUserException, DataAccessException;
	
	public List<User> getAllUser() throws DataAccessException;
	
	public void createUser(User newUser) throws UserAlreadyExistsException, DataAccessException;
	
	public void updateUser(User user) throws UnknownUserException, DataAccessException;
	
	public void removeUser(String username) throws UnknownUserException, DataAccessException;

}
