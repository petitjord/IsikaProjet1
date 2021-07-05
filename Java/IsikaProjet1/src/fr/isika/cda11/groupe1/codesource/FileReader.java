package fr.isika.cda11.groupe1.codesource;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {


	public static void main(String[] args) {

		try {
			FileInputStream file = new FileInputStream("c:/GitHubRepo/IsikaProjet1/STAGIAIRES.DON");
			Scanner scanner = new Scanner(file);

			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}

