module AnnuaireStagiaireApp {
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires itextpdf;

	opens application to javafx.base, javafx.controls, javafx.graphics, javafx.fxml;
}
