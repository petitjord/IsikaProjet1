package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AnnuaireFileWriter {
	
	public void getListAnnuaireBinaire(List<Stagiaire> stagiaires ) {
		
		File listStagiaireDon = new File("C:/STAGIAIRES.DON");
		File annuaireFolder = new File("C://Users//leann//Desktop/dossierAnnuaire/");
		File annuaireFile = new File("C://Users//leann//Desktop/dossierAnnuaire/annuaire.txt");
		//annuaireBinaire = new Annuaire();
		//List<Stagiaire> listStagiaireDansArbreBinaire = annuaireBinaire.getListStagiaireDansArbreBinaire();
		
		if(!annuaireFolder.exists()) {
			annuaireFolder.mkdir();
		}
		
		if(!annuaireFile.exists()) {
			try {
				annuaireFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				FileWriter annuaireWriter = new FileWriter(annuaireFile);
				BufferedWriter annuaireBw = new BufferedWriter(annuaireWriter);
				//FileInputStream fileDon = new FileInputStream("C:/STAGIAIRES.DON");
				//fileDon.transferTo(new FileOutputStream("C:/Users/leann/Desktop/dossierAnnuaire/annuaire.txt"));
				annuaireBw.write(stagiaires.get(0).nom);
				annuaireBw.write(stagiaires.get(0).prenom);
				annuaireBw.write(stagiaires.get(0).departement);
				annuaireBw.write(stagiaires.get(0).promo);
				annuaireBw.write(stagiaires.get(0).annee);
				annuaireBw.newLine();
				annuaireBw.close();
				annuaireWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
