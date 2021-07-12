package application;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDF {

	public void affiche () {

		System.out.println("affiche");

		String document = ("C:/gitHubRepo/Projet1_Github/IsikaProjet1/Manuel_d'utilisation_annuaire_v2.pdf");

		try {

			PdfReader pdfreader = new PdfReader(document);
			String content = PdfTextExtractor.getTextFromPage(pdfreader, 1);
			System.out.println(content);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
	}

}