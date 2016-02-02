package myproject.service;

import myproject.data.DatabaseUserData;
import myproject.data.UserDataAccess;
import myproject.exception.DataAccessException;
import myproject.exception.UserAlreadyExistsException;
import myproject.model.User;

public class UserManagementService {
    
    public UserDataAccess userDataAccess = new DatabaseUserData();
    
    public void createUser(String username, String password) throws UserAlreadyExistsException, DataAccessException{
	
	userDataAccess.createUser(new User(username, password));
    }

}
