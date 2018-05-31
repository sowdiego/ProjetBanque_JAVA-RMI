package com.projet.ui.menu;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.projet.entities.Agence;
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

public class TransactionController implements Initializable {

	@FXML
    private TextField numC_Expe;

    @FXML
    private TextField numC_Rece;

    @FXML
    private Button searchExp;

    @FXML
    private Button searchRec;

    @FXML
    private TextField somme_txt;

    @FXML
    private Label cniExp_lbl;

    @FXML
    private Label nomExp_lbl;

    @FXML
    private Label prenomExp_lbl;

    @FXML
    private Label soldeExp_lbl;

    @FXML
    private Label cniRec_lbl;

    @FXML
    private Label nomRec_lbl;

    @FXML
    private Label prnomRec_lbl;

    @FXML
    private Label soldeRec_lbl;

    @FXML
    private Button valider_btn;

    @FXML
    private Button annuler_btn;

    @FXML
    private TextField TAXE;

    @FXML
    private ComboBox<Agence> agence;

    @FXML
    private DatePicker dateOP;

    @FXML
    void loadAgencde(ActionEvent event) {

    }

    @FXML
    void recherccheExp(ActionEvent event) {
    	Compte ok = null;
		try{
		ok =Fabrique.icpt.getCompteByNum(numC_Expe.getText());
		if (ok != null) {
			recupCompte=ok;
			//Notification.NotifSucces("info", "ce client existe");
		  cniExp_lbl.setText(ok.getClient().getNum_piece());
		  nomExp_lbl.setText(ok.getClient().getNom());
		  prenomExp_lbl.setText(ok.getClient().getPrenom());
		  soldeExp_lbl.setText(ok.getSolde()+"");
		} else {
			Notification.NotifError("info", "ce client n'existe pas");
		}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void rechercheRec(ActionEvent event) {
    	Compte ok = null;
		try{
			if (numC_Expe.getText().equalsIgnoreCase(numC_Rece.getText())) {
				Notification.NotifError("info", "Transaction Impossible");
			}else{
		ok =Fabrique.icpt.getCompteByNum(numC_Rece.getText());
		if (ok != null) {

			//Notification.NotifSucces("info", "ce client existe");
		  cniRec_lbl.setText(ok.getClient().getNum_piece());
		  nomRec_lbl.setText(ok.getClient().getNom());
		  prnomRec_lbl.setText(ok.getClient().getPrenom());
		  soldeRec_lbl.setText(ok.getSolde()+"");
		} else {
			Notification.NotifError("info", "ce client n'existe pas");
		}
		}

		} catch (Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void annuler(ActionEvent event) {

    }
    Compte recupCompte = null;
    @FXML
    void valider(ActionEvent event) {
    	int ok;

    	try {
    		if (Integer.parseInt(somme_txt.getText())< Integer.parseInt(soldeExp_lbl.getText()))
    		{
			ok=Fabrique.icpt.updateSoldeDepot
					(Integer.parseInt(somme_txt.getText()),numC_Rece.getText());

			soldeRec_lbl.setText(Integer.parseInt(soldeRec_lbl.getText())+Integer.parseInt(somme_txt.getText())+"");
			soldeExp_lbl.setText(Integer.parseInt(soldeExp_lbl.getText())-Integer.parseInt(TAXE.getText())-Integer.parseInt(somme_txt.getText())+"");
			Operation op = new Operation();

			op.setDate(((TextField)dateOP.getEditor()).getText());
			op.setCompte(recupCompte);
			op.setMontant(Integer.parseInt(somme_txt.getText()));
			op.setTypeOp("transaction");
			op.setAgence(agence.getValue());
			op.setTaxe(Integer.parseInt(TAXE.getText()));
			if (Fabrique.iop.add(op)!=0 ) {
				Notification.NotifSucces("info", "Operation Reussit");
			}
    		}else {
    			Notification.NotifError("info", "Solde Insuffisant");
			}
		      } catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }


    private void comboAgence() throws RemoteException {
     	 ObservableList<Agence> l_agence =
     				FXCollections.observableArrayList();
     	Fabrique.icpt.listeAg().stream().
     	forEach(agence->{l_agence.add(agence);});
  		 agence.setItems(l_agence);

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
