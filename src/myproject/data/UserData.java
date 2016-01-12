package myproject.data;

import java.util.LinkedList;
import java.util.List;

import myproject.exception.UnknownUserException;
import myproject.model.User;

public class UserData {

	List<User> utilisateurs = new LinkedList<User>();

	public UserData() {
		// Jeu d'essai
		utilisateurs.add(new User("Robert", "licorne42"));
		utilisateurs.add(new User("Paul", "licorne43"));
		utilisateurs.add(new User("Jean", "licorne44"));
	}

	public User trouverUtilisateur(String username) throws UnknownUserException {

		for (User u : utilisateurs) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}

		throw new UnknownUserException();

	}
}
