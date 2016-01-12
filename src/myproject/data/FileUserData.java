package myproject.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import myproject.exception.UnknownUserException;
import myproject.exception.UserAlreadyExistsException;
import myproject.exception.UserLoadingException;
import myproject.model.User;

public class FileUserData implements UserDataAccess {

	public List<User> users = null;

	private static final String FILE_PATH = "C:\\data\\users.ser";
	

	@SuppressWarnings("unchecked")
	private void loadUsersFromFile() throws UserLoadingException {
		File fichier = new File(FILE_PATH);
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(fichier));
			users = (ArrayList<User>) ois.readObject();
		} catch (FileNotFoundException e) {
			users = new ArrayList<User>();
			return;
		} catch (IOException e) {
			throw new UserLoadingException();
		} catch (ClassNotFoundException e) {
			throw new UserLoadingException();
		} finally {
			closeInputStream(ois);
		}

	}

	private void loadUsersIfRequired() throws UnknownUserException {
		if (users == null) {
			try {
				loadUsersFromFile();
			} catch (UserLoadingException e) {
				System.err.println("Error while loading the user file");
				throw new UnknownUserException();
			}
		}
	}

	private void closeInputStream(ObjectInputStream ois) {
		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				System.err.println("Error while closing the file");
			}
		}
	}

	@Override
	public User findUser(String username) throws UnknownUserException {

		loadUsersIfRequired();
		
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}

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
