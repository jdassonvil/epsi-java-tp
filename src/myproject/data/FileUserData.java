package myproject.data;

import java.util.List;

import myproject.exception.UnknownUserException;
import myproject.exception.UserAlreadyExistsException;
import myproject.model.User;

public class FileUserData implements UserDataAccess{

	@Override
	public User findUser(String username) throws UnknownUserException {
		// TODO Auto-generated method stub
		return null;
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
