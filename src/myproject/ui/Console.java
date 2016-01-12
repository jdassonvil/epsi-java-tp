package myproject.ui;

import java.util.Scanner;

import myproject.service.AuthentificationService;

public class Console {

	public static void promptLogin() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Login");
		String username = sc.nextLine();
		
		System.out.println("Password");
		String password = sc.nextLine();
		
		AuthentificationService authentificationService = new AuthentificationService();
		
		if(authentificationService.login(username, password)){
			System.out.println("Vous �tes authentifi�");
		}else{
			System.out.println("Echec de l'authentification");
		}
		
		sc.close();
	}

}