package com.projet.ui.menu;
import java.net.URL;
import java.util.ResourceBundle;

import com.projet.entities.Compte;
import com.projet.tools.Fabrique;
import com.projet.tools.Notification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class consultationController implements Initializable {

	  @FXML
	    private TextField compteRechercher;

	    @FXML
	    private Button recherche;

	    @FXML
	    private Label numCNI;

	    @FXML
	    private Label prenom;

	    @FXML
	    private Label nom;

	    @FXML
	    private Label adresse;

	    @FXML
	    private Label tel;

	    @FXML
	    private Label numCompte;

	    @FXML
	    private Label cliRib;

	    @FXML
	    private Label solde;

	    @FXML
	    private Label typeCompte;

	    @FXML
	    void rechercher(ActionEvent event) {
	    	Compte ok = null;
			try{
			ok =Fabrique.icpt.getCompteByNum(compteRechercher.getText());
			if (ok != null) {
			  numCNI.setText(ok.getClient().getNum_piece());
			  nom.setText(ok.getClient().getNom());
			  prenom.setText(ok.getClient().getPrenom());
			  adresse.setText(ok.getClient().getAdresse());
			  tel.setText(ok.getClient().getTel());
			  numCompte.setText(ok.getNumero());
			  cliRib.setText(ok.getCleRIB());
			  solde.setText(ok.getSolde()+"");
			  //typeCompte.setText(ok.getTypeCompte().getNomType());


			} else {
				Notification.NotifError("info", "ce compte n'existe pas");
			}

			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			Fabrique.init();

		}

}
