package com.projet.ui.menu;
import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.projet.entities.Agence;
import com.projet.entities.Client;
import com.projet.entities.Compte;
import com.projet.entities.Operation;
import com.projet.tools.Fabrique;
import com.projet.tools.Notification;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class OperationController implements Initializable{
	 @FXML
	    private Button search_btn;

	    @FXML
	    private Label cni_lbl;

	    @FXML
	    private Label nom_lbl;

	    @FXML
	    private Label prenom_lbl;

	    @FXML
	    private Label solde_lbl;

	    @FXML
	    private TextField somme_txt;
	    @FXML
	    private TextField seach_numC;

	    @FXML
	    private Button valider_btn;

	    @FXML
	    private Button annuler_btn;
	    @FXML
	    private Button depot_btn;

	    @FXML
	    private TextField TAXE;

	    @FXML
	    private ComboBox<Agence> agence;

	    @FXML
	    private DatePicker dateOP;


	    @FXML
	    void annuler(ActionEvent event) {

	    }

	    @FXML
	    void loadAgencde(ActionEvent event) {

	    }
	    private void comboAgence() throws RemoteException {
	      	 ObservableList<Agence> l_agence =
	      				FXCollections.observableArrayList();
	      	Fabrique.icpt.listeAg().stream().
	      	forEach(agence->{l_agence.add(agence);});
	   		 agence.setItems(l_agence);

	      }

	    @FXML
	    void depot(ActionEvent event) {
	    	int ok;

	    	try {

				ok=Fabrique.icpt.updateSoldeDepot
						(Integer.parseInt(somme_txt.getText()),seach_numC.getText());

				solde_lbl.setText(Integer.parseInt(solde_lbl.getText())-Integer.parseInt(TAXE.getText())+Integer.parseInt(somme_txt.getText())+"");
				Operation op = new Operation();

				op.setDate(((TextField)dateOP.getEditor()).getText());
				op.setCompte(recupCompte);
				op.setMontant(Integer.parseInt(somme_txt.getText()));
				op.setTypeOp("Depot");
				op.setAgence(agence.getValue());
				op.setTaxe(Integer.parseInt(TAXE.getText()));
				if (Fabrique.iop.add(op)!=0 ) {
					Notification.NotifSucces("info", "Operation Reussit");
				}

			} catch (NumberFormatException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
         Compte recupCompte = null;
	    @FXML
	    void rechercheCompte(ActionEvent event)throws RemoteException {
	    	Compte ok = null;
			try{
			ok =Fabrique.icpt.getCompteByNum(seach_numC.getText());
			if (ok != null) {
				recupCompte = ok;
				//Notification.NotifSucces("info", "ce client existe");
			  cni_lbl.setText(ok.getClient().getNum_piece());
			  nom_lbl.setText(ok.getClient().getNom());
			  prenom_lbl.setText(ok.getClient().getPrenom());
			  solde_lbl.setText(ok.getSolde()+"");
			} else {
				Notification.NotifError("info", "ce client n'existe pas");
			}

	} catch (Exception e) {
		e.printStackTrace();
	}

	    }

	    @FXML
	    void valider(ActionEvent event) {
	    	int ok;

	    	try {
	    		if (Integer.parseInt(somme_txt.getText())< Integer.parseInt(solde_lbl.getText()))
	    		{
	    			ok=Fabrique.icpt.updateSolde
							(Integer.parseInt(somme_txt.getText()),seach_numC.getText());

	    			solde_lbl.setText(Integer.parseInt(solde_lbl.getText())-Integer.parseInt(TAXE.getText())-Integer.parseInt(somme_txt.getText())+"");
	    				Operation op = new Operation();

	    				op.setDate(((TextField)dateOP.getEditor()).getText());
	    				op.setCompte(recupCompte);
	    				op.setMontant(Integer.parseInt(somme_txt.getText()));
	    				op.setTypeOp("Retrait");
	    				op.setAgence(agence.getValue());
	    				op.setTaxe(Integer.parseInt(TAXE.getText()));
	    				if (Fabrique.iop.add(op)!=0 ) {
	    					Notification.NotifSucces("info", "Operation Reussit");
						}
				}else{
					Notification.NotifError("info", "Solde Insuffisant");
				}




			} catch (NumberFormatException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			try {
			Fabrique.init();
			dateOP.setValue(LocalDate.now());

				comboAgence();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}


