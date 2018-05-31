package com.projet.ui.menu;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import com.projet.entities.Agence;
import com.projet.entities.Charge_Compte;
import com.projet.entities.Client;
import com.projet.entities.Compte;
import com.projet.entities.Employeur;
import com.projet.entities.TypeCompte;
import com.projet.tools.Fabrique;
import com.projet.tools.Notification;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NewCompteController implements Initializable {


    @FXML
    private TextField cni_txt;

    @FXML
    private TextField numCompte_txt;

    @FXML
    private DatePicker date_Ouv_pk;

    @FXML
    private ComboBox<TypeCompte> typeCompte_cbx;

    @FXML
    private TextField solde_txt;

    @FXML
    private TextField fraisOuv_txt;

    @FXML
    private TextField remu_txt;

    @FXML
    private TextField agio_txt;

    @FXML
    private ComboBox<String> etat_cbx;

    @FXML
    private TextField delai_txt;



    @FXML
    private DatePicker dateGele_pk;

    @FXML
    private Button valider_btn;

    @FXML
    private Button annuler_btn;

    @FXML
    private ComboBox<Charge_Compte> chargerCompte_cbx;
    @FXML
    private CheckBox remu_check;
    @FXML
    private ComboBox<Agence> agence_cbx;

    @FXML
    private TextField compte_txt_recherche;

    @FXML
    private Button recherche_btn;

    @FXML
    private TextField cleRIB_txt;

    @FXML
    void rechercherCompte(ActionEvent event) {
    }
    @FXML
    void annuler(ActionEvent event) {

    }
    @FXML
    void chargeCompte(ActionEvent event) {

    }
    @FXML
    void loadAgence(ActionEvent event) {

    }
    private void verifierDelai(){
    	delai_txt.focusedProperty().addListener(
				(obs, oldDelai, newdelai) -> {
			try {
				if (!newdelai) {

					if (Integer.parseInt(delai_txt.getText())<12) {
						Alert alert=new Alert(Alert.AlertType.WARNING);
						alert.setTitle("Banque du Peuple");
						alert.setHeaderText("Compte");
						alert.setContentText(" le delai doit etre superieur a 12 mois");
						alert.showAndWait();
						delai_txt.setText("");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

    }
    @FXML
    void verifierDelai(ActionEvent event) {

    }

    @FXML
    void valider(ActionEvent event) throws RemoteException {
    	 if(!cni_txt.getText().equals("") || solde_txt.getText().equals("")
    			 ) {


	    	Compte c = new Compte();
	    	c.setNumero(numCompte_txt.getText());
	    	c.setDateOuverture(((TextField)date_Ouv_pk.getEditor()).getText());
	    	c.setTypeCompte(typeCompte_cbx.getValue());
	    	c.setSolde(Integer.parseInt(solde_txt.getText()));
	    	c.setChargeCompte(chargerCompte_cbx.getValue());
	    	c.setEtatCompte(etat_cbx.getValue());
	    	c.setClient(CompteNewClientController.cli);//setNum_piece(cni_txt.getText());
	    	c.setAgence(agence_cbx.getValue());
	    	c.setCleRIB(cleRIB_txt.getText());

	    	if(typeCompte_cbx.getSelectionModel().getSelectedIndex()==0	||
	    	    typeCompte_cbx.getSelectionModel().getSelectedIndex()==1){
	    		c.setFraisOuverture(Integer.parseInt(fraisOuv_txt.getText()));
	    		c.setRemuneration("Oui");

	    	}if (typeCompte_cbx.getSelectionModel().getSelectedIndex()==2) {

		    	c.setAgio(Integer.parseInt(agio_txt.getText()));
			}
	    	if (typeCompte_cbx.getSelectionModel().getSelectedIndex()==3)
	    	{
	    	   c.setDelaiBlocage(Integer.parseInt(delai_txt.getText()));
	    	}

	    	if(Fabrique.icpt.add(c) != 0){
	    		Notification.NotifSucces("Info", "Compte Enregistre");

	    	}else{
	    		Notification.NotifError("Erreur", "Compte non ajoutées");
	    	}
    	 }
    	}



    @FXML
   private void loadComboTypeCompte() throws RemoteException {

    	if(typeCompte_cbx.getSelectionModel().getSelectedIndex()==0||
    	typeCompte_cbx.getSelectionModel().getSelectedIndex()==1){
   		 fraisOuv_txt.setDisable(false);
   		 remu_check.setSelected(true);
    	}
    	if (typeCompte_cbx.getSelectionModel().getSelectedIndex()==2) {
    		fraisOuv_txt.setDisable(true);
    		agio_txt.setDisable(false);
    	}
    	if(typeCompte_cbx.getSelectionModel().getSelectedIndex()==3){
    	   		 fraisOuv_txt.setDisable(false);
    	   		 remu_check.setSelected(true);
    	   		 delai_txt.setDisable(false);
    	   }

    }
    private void comboCompte() throws RemoteException {
    	 ObservableList<TypeCompte> l_typeC =
    				FXCollections.observableArrayList();
    	Fabrique.itc.listeTC().stream().
    	forEach(typeclient->{l_typeC.add(typeclient);});
		 typeCompte_cbx.setItems(l_typeC);

    }
    private void comboAgence() throws RemoteException {
   	 ObservableList<Agence> l_agence =
   				FXCollections.observableArrayList();
   	Fabrique.icpt.listeAg().stream().
   	forEach(agence->{l_agence.add(agence);});
		 agence_cbx.setItems(l_agence);

   }

    private void comboChargerCompte() throws RemoteException {
   	 ObservableList<Charge_Compte> l_chC =
   				FXCollections.observableArrayList();
   	Fabrique.icpt.listeChC().stream().
   	forEach(charge_compte->{l_chC.add(charge_compte);});
		chargerCompte_cbx.setItems(l_chC);
   }

    @FXML
    void loadComboEtat() {
    	ObservableList<String> l_Etat =
    			FXCollections.observableArrayList("Actif","Ferme","Bloque","Gele");
    	etat_cbx.setItems(l_Etat);
    }

    @FXML
    void recup_cni() {
    	cni_txt.setText(CompteNewClientController.cni_recup);
    }
  private void griser(){
	    cni_txt.setDisable(true);
		numCompte_txt.setDisable(true);
		fraisOuv_txt.setDisable(true);
		agio_txt.setDisable(true);
		delai_txt.setDisable(true);
		dateGele_pk.setDisable(true);
		date_Ouv_pk.setDisable(true);
		remu_check.setDisable(true);
		cleRIB_txt.setDisable(true);
  }
  void verifdelai(){

  }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
		Fabrique.init();
		griser();
		loadComboEtat();
		verifierDelai();
		comboChargerCompte();
		comboCompte();
		comboAgence();
		recup_cni();
		etat_cbx.getSelectionModel().selectFirst();
		numCompte_txt.setText(Fabrique.icli.numCompte());
		cleRIB_txt.setText(Fabrique.icpt.cleRIB()+" "+numCompte_txt.getText());
		date_Ouv_pk.setValue(LocalDate.now());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
