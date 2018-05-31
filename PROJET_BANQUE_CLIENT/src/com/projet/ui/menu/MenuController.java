package com.projet.ui.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.projet.tools.LoadView;
import com.projet.tools.Tools;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;


public class MenuController implements Initializable {
	 @FXML
	  private MenuItem newClient_itm;
	    @FXML
	    private MenuItem retrait;

	    @FXML
	    private MenuItem depot;

	    @FXML
	    private MenuItem transaction;

	    @FXML
	    void loadNewClient(ActionEvent event) throws IOException {
	    	LoadView.showView("Gestion de Compte","CompteNewClient.fxml",3);

	    }
	    @FXML
	    void loadCreerCompte(ActionEvent event) {
	    	LoadView.showView("Gestion de Compte","NewCompte.fxml",3);

	    }
	    @FXML
	    void loadDepot(ActionEvent event) {
	    	LoadView.showView("Gestion de Compte","Retrait.fxml",3);
	    }
	    @FXML
	    void loadCconsultation(ActionEvent event) {
	    	LoadView.showView("Gestion de Compte","Operation.fxml",3);
	    }


	    @FXML
	    void loadRetrait(ActionEvent event) {
	    	LoadView.showView("Gestion de Compte","Retrait.fxml",3);

	    }

	    @FXML
	    void loadTransacgtion(ActionEvent event) {
	    	LoadView.showView("Gestion de Compte","Transacton.fxml",3);
	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

		}


}
