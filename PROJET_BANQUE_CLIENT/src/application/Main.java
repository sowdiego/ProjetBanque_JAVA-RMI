package application;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projet.entities.User;
import com.projet.tools.Fabrique;
import com.projet.tools.LoadView;
import com.projet.tools.Notification;
import com.projet.tools.Tools;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;



public class Main extends Application {

	    @FXML
	    private TextField login_txt;

	    @FXML
	    private PasswordField password_txt;



	public void getConnexion(ActionEvent event) throws IOException
	{

		String titre = "Info";
		String l = login_txt.getText();
		String p = password_txt.getText();

		if(l.trim().equals("") || p.trim().equals("")){
			Notification.NotifError(titre, "Veuillez remplir tous les champs !!");
		}else{
			User u = new User();
			u.setLoginU(l);
			u.setPasswordU(p);
			Fabrique.init();

			if(Fabrique.udb.getConnexion(u)){

				LoadView.showView("Gestion de Compte","Menu.fxml",2);
				/*String url = "/com/projet/ui/menu/Menu.fxml";
				Tools.myLoadPage(event, url);
				//Notification.NotifSucces(titre, "infos OK");*/
			}else{
				Notification.NotifError(titre, "Login ou mot de passe incorrect !!");
			}
		}
	}



	private void showMessage(String titre, String message)
	{
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle(titre);
		a.setContentText(message);
		a.showAndWait();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
