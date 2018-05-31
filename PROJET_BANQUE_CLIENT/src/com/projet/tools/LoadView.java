package com.projet.tools;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoadView
{

	private static Parent root;
	private static int type;

	private static BorderPane rootBorder;

	private static Scene scene;
	private static Stage stage;
	private static String title;
	private static String name;

	private static void initStatge()
	{
		if(stage==null){
			stage=new Stage();
		}
	}


	public static Stage getStage() {
		return stage;
	}


	public static void setStage(Stage stage) {
		LoadView.stage = stage;
	}


	public static void showView(String titre,String nom, int letype)
	{
		title=titre;
		name=nom;
		type = letype;
		initStatge();
		Load(type);
	}

	private static void Load(int type)
	{
		try
		{
			if(type == 1){
				root=FXMLLoader.load(LoadView.class.getResource("/com/projet/ui/menu/"+name));
				scene=new Scene(root);
				stage.setScene(scene);
				stage.setTitle(title);
				stage.centerOnScreen();
				showed();
			}
			else if(type == 2)
			{
				rootBorder=FXMLLoader.load(LoadView.class.getResource("/com/projet/ui/menu/"+name));
				scene=new Scene(rootBorder);
				stage.setScene(scene);
				stage.setTitle(title);
				stage.centerOnScreen();
				showed();
			}
			else{
				root=FXMLLoader.load(LoadView.class.getResource("/com/projet/ui/menu/"+name));
				rootBorder.setCenter(root);
			}

			//stage.setResizable(false);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}



	private static void showed()
	{
		stage.show();
	}

}
