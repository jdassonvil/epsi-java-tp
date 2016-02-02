package myproject.ui;

import java.util.Scanner;

import myproject.exception.DataAccessException;
import myproject.exception.UserAlreadyExistsException;
import myproject.service.AuthentificationService;
import myproject.service.UserManagementService;

public class Console {

    private static String askForPassword(Scanner sc) {
	System.out.println("Password");
	String password = sc.nextLine();
	return password;
    }

    private static String askForLogin(Scanner sc) {
	System.out.println("Login");
	String username = sc.nextLine();
	return username;
    }

    public static void promptLogin() {
	Scanner sc = new Scanner(System.in);

	String username = askForLogin(sc);
	String password = askForPassword(sc);

	AuthentificationService authentificationService = new AuthentificationService();

	if (authentificationService.login(username, password)) {
	    System.out.println("Vous êtes authentifié");
	    return;
	}

	System.out.println("Echec de l'authentification");

	sc.close();
    }

    public static void promptCreateUser() {
	Scanner sc = new Scanner(System.in);

	String username = askForLogin(sc);
	String password = askForPassword(sc);

	UserManagementService userManagementService = new UserManagementService();

	try {
	    userManagementService.createUser(username, password);
	    System.out.println("Compte créé avec succès");
	} catch (UserAlreadyExistsException e) {
	    System.err.println("Ce nom d'utilisateur est déjà utilisé");
	} catch (DataAccessException e) {
	    System.err.println("Une erreur est surevenue, votre compte n'a pas été créé");
	}
    }

    public static void promptMenu() {
	Scanner sc = new Scanner(System.in);

	System.out.println("1) Se connecter");
	System.out.println("2) Créé un nouveau compte");

	String value = sc.nextLine();

	try {
	    int choice = Integer.parseInt(value);

	    switch (choice) {
	    case 1:
		promptLogin();
		break;
	    case 2:
		promptCreateUser();
		break;
	    default:
		throw new Exception("Unsupported value");
	    }

	} catch (Exception e) {
	    System.err.println("Saisissez 1 ou 2");
	}

    }

}
