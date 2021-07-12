package application;

import java.io.File;
import java.io.IOException;

public class OuvrirPDF {

	public static void main(String[] args) {
		OuvrirPDF pdf = new OuvrirPDF();
		pdf.open();
	}

	public void open() {
		String filename = OuvrirPDF.class.getResource("/doc/ressources/Manuel_d'utilisation_annuaire_v2.pdf").getFile();
		File file = new File(filename);
		try {
			Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
			p.waitFor();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}
