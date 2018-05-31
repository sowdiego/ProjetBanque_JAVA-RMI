package com.projet.ui.menu;

import java.net.URL;
import java.rmi.RemoteException;

import java.util.ResourceBundle;

import com.projet.entities.Client;
import com.projet.entities.Employeur;
import com.projet.entities.TypeClient;
import com.projet.tools.Fabrique;
import com.projet.tools.LoadView;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class CompteNewClientController implements Initializable {

	public static String cni_recup = "";


	@FXML
	private TextField cni_txt;

	@FXML
	private TextField nom_txt;

	@FXML
	private TextField prenom_txt;

	@FXML
	private TextField adresse_txt;

	@FXML
	private TextField tel_txt;

	@FXML
	private TextField salaire_txt;

	@FXML
	private TextField profession_txt;

	@FXML
	private ComboBox<Integer> typeClient_cbx;

	@FXML
	private Button valider_cli_btn;

	@FXML
	private TextField email_txt;

	@FXML
	private ComboBox<Employeur> employeur_cbx;

	@FXML
	private TableColumn<?, ?> col_cni;

	@FXML
	private TableColumn<?, ?> col_nom;

	@FXML
	private TableColumn<?, ?> col_prenom;

	@FXML
	private TableColumn<?, ?> col_adresse;

	@FXML
	private TableColumn<?, ?> col_tel;

	@FXML
	private TableColumn<?, ?> col_email;

	@FXML
	private TableColumn<?, ?> col_typecli;

	@FXML
	private TableColumn<?, ?> col_profession;

	@FXML
	private TableColumn<?, ?> col_salaire;

	@FXML
	private TableColumn<?, ?> col_employeur;
	@FXML
	private CheckBox oui_chek;

	@FXML
	private CheckBox non_chek;
	@FXML

	private ComboBox<String> raison_social_cbx;

	@FXML
	private TextField ad_Emp;

	@FXML
	private TextField nom_Emp;

	@FXML
	private TextField id_Emp;
	@FXML
	private Button search_btn;
	@FXML
	private TextField cni_txt1;
	@FXML
	private Label prenom;
	@FXML
    private Button nouveau_compte;
	@FXML
	void nouveauCompte(ActionEvent event) {
		LoadView.showView("Gestion de Compte", "NewCompte.fxml", 3);
	}
	@FXML
	void searchCNI(ActionEvent event) throws RemoteException {
		Client ok ;
		try{
		ok = Fabrique.icli.getClientByCNI(cni_txt1.getText());
		if (ok != null) {
			cni_txt.setText(ok.getNum_piece());
			cni_recup = ok.getNum_piece();
			nom_txt.setText(ok.getNom());
			prenom_txt.setText(ok.getPrenom());
			adresse_txt.setText(ok.getAdresse());
			tel_txt.setText(ok.getTel());
			email_txt.setText(ok.getEmail());
			salaire_txt.setText(ok.getSalaire()+"");
			profession_txt.setText(ok.getProfession());
			//raison_social_cbx.setValue(ok.getRaison_sociale());
			ad_Emp.setText(ok.getAdressEmp());
			nom_Emp.setText(ok.getNomEmp());
			id_Emp.setText(ok.getNumEmp());
			valider_cli_btn.setDisable(true);

		} else {
			Notification.NotifError("info", "ce client n'existe pas");
		}

} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

	private void rechercheCNI() {
		cni_txt.focusedProperty().addListener(
				(obs, oldMatricule, newMatricule) -> {
			try {
				if (!newMatricule) {
					Client ok ;
					ok = Fabrique.icli.getClientByCNI(cni_txt.getText());
					if (ok != null) {
						Alert alert=new Alert(Alert.AlertType.WARNING);
						alert.setTitle("Banque du Peuple");
						alert.setHeaderText("Client");
						alert.setContentText(" ce client existe");
						alert.showAndWait();
						cni_txt.setText("");
						valider_cli_btn.setDisable(true);
					} else {
						valider_cli_btn.setDisable(false);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	@FXML
	void loadcomboRS() {
		ObservableList<String> l_RS =
				FXCollections.observableArrayList("SA", "SARL", "SNC", "SCS");
		raison_social_cbx.setItems(l_RS);
	}

	@FXML
	void nonSalarier(ActionEvent event) {
		if (non_chek.isSelected()) {
			salaire_txt.setDisable(true);
			profession_txt.setDisable(true);
			raison_social_cbx.setDisable(true);
			ad_Emp.setDisable(true);
			nom_Emp.setDisable(true);
			id_Emp.setDisable(true);
		}

	}

	@FXML
	void ouiSalarier(ActionEvent event) {
		if (oui_chek.isSelected()) {
			salaire_txt.setDisable(false);
			profession_txt.setDisable(false);
			raison_social_cbx.setDisable(false);
			raison_social_cbx.setDisable(false);
			ad_Emp.setDisable(false);
			nom_Emp.setDisable(false);
			id_Emp.setDisable(false);
		}
	}

	public static int idEmpRecup;
	public static Client cli;

	@FXML
	void valider_cli(ActionEvent event) throws RemoteException {

		if (!nom_txt.getText().equals("") || !prenom_txt.getText().equals("") || !cni_txt.getText().equals("")
				|| !adresse_txt.getText().equals("") || !tel_txt.getText().equals("")
				|| !email_txt.getText().equals("")) {
			Client c = new Client();
			c.setNum_piece(cni_txt.getText());
			cni_recup = c.getNum_piece();
			c.setNom(nom_txt.getText());
			c.setPrenom(prenom_txt.getText());
			c.setAdresse(adresse_txt.getText());
			c.setEmail(email_txt.getText());
			c.setTel(tel_txt.getText());
			if (oui_chek.isSelected()) {
				c.setRaison_sociale(raison_social_cbx.getValue());
				c.setAdressEmp(ad_Emp.getText());
				c.setNomEmp(nom_Emp .getText());
				c.setNumEmp(id_Emp.getText());
				c.setSalaire(Integer.parseInt(salaire_txt.getText()));
				c.setProfession(profession_txt.getText());

			}

			if (Fabrique.icli.add(c) != 0) {
				Notification.NotifSucces("Info", "Client Enregistre");

			} else {
				Notification.NotifError("Erreur", "Client non ajoutées");
			}
			cli=c;
		}


		LoadView.showView("Gestion de Compte", "NewCompte.fxml", 3);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Fabrique.init();
		loadcomboRS();
		rechercheCNI();
		salaire_txt.setDisable(true);
		profession_txt.setDisable(true);
		raison_social_cbx.setDisable(true);
		ad_Emp.setDisable(true);
		nom_Emp.setDisable(true);
		id_Emp.setDisable(true);
	}

}
