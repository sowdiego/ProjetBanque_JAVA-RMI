package com.projet.tools;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.projet.dao.IClient;
import com.projet.dao.ICompte;
import com.projet.dao.IEmployeur;
import com.projet.dao.IUser;
import com.projet.dao.Ioperation;
import com.projet.dao.ItypeClient;
import com.projet.dao.ItypeCompte;



public class Fabrique {
	public static IUser udb;
	public static ItypeCompte itc;
	public static IEmployeur iEmp;
	public static IClient icli;
	public static ICompte icpt;
	public static Ioperation iop;


	public static void init(){
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",1222);
			udb = (IUser)registry.lookup("user_db");
			itc = (ItypeCompte)registry.lookup("typeCompte_db");
			iEmp = (IEmployeur)registry.lookup("employeur_db");
			icli = (IClient)registry.lookup("Client_db");
			icpt = (ICompte)registry.lookup("compte_db");
			iop = (Ioperation)registry.lookup("operation_db");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
