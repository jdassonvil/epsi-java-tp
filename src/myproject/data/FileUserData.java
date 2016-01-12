package myproject.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import myproject.exception.UnknownUserException;
import myproject.exception.UserAlreadyExistsException;
import myproject.exception.DataAccessException;
import myproject.model.User;

public class FileUserData implements UserDataAccess {

    public List<User> users = null;

    private static final String FILE_PATH = "C:\\data\\users.ser";

    @SuppressWarnings("unchecked")
    private void loadUsersFromFile() throws DataAccessException {
	File file = new File(FILE_PATH);
	ObjectInputStream ois = null;

	try {
	    ois = new ObjectInputStream(new FileInputStream(file));
	    users = (ArrayList<User>) ois.readObject();
	} catch (FileNotFoundException e) {
	    users = new ArrayList<User>();
	    return;
	} catch (IOException e) {
	    throw new DataAccessException();
	} catch (ClassNotFoundException e) {
	    throw new DataAccessException();
	} finally {
	    closeStream(ois);
	}

    }

    private void saveUsers() throws DataAccessException {
	File file = new File(FILE_PATH);
	ObjectOutputStream oos = null;

	try {
	    oos = new ObjectOutputStream(new FileOutputStream(file));
	    oos.writeObject(users);
	} catch (Exception e) {
	    throw new DataAccessException();
	} finally {
	    closeStream(oos);
	}
    }

    private void loadUsersIfRequired() throws DataAccessException {
	if (users == null) {
	    loadUsersFromFile();
	}
    }

    private void closeStream(AutoCloseable stream) {
	if (stream != null) {
	    try {
		stream.close();
	    } catch (Exception e) {
		System.err.println("Error while closing the file");
	    }
	}
    }

    @Override
    public User findUser(String username) throws UnknownUserException, DataAccessException {

	loadUsersIfRequired();

	for (User u : users) {
	    if (u.getUsername().equals(username)) {
		return u;
	    }
	}

	return null;
    }

    @Override
    public List<User> getAllUser() throws DataAccessException {

	loadUsersIfRequired();
	return users;
    }

    @Override
    public void createUser(User newUser) throws UserAlreadyExistsException, DataAccessException {

	try {
	    findUser(newUser.getUsername());
	    throw new UserAlreadyExistsException();
	} catch (UnknownUserException e) {
	    users.add(newUser);
	    saveUsers();
	}
    }

    @Override
    public void updateUser(User newUser) throws UnknownUserException, DataAccessException {
	User oldUser = findUser(newUser.getUsername());
	
	// Update if the two objets are differents
	if(!oldUser.equals(newUser)){
	    this.users.remove(oldUser);
	    this.users.add(newUser);
	    saveUsers();
	}

    }

    @Override
    public void removeUser(String username) throws UnknownUserException, DataAccessException {
	User user = findUser(username);
	this.users.remove(user);
	saveUsers();
    }

}
