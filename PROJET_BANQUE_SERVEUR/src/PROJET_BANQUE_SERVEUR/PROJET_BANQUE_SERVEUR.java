package PROJET_BANQUE_SERVEUR;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.projet.dao.ClientDB;
import com.projet.dao.CompteDB;
import com.projet.dao.EmployeurDB;
import com.projet.dao.IClient;
import com.projet.dao.ICompte;
import com.projet.dao.IEmployeur;
import com.projet.dao.IUser;
import com.projet.dao.Ioperation;
import com.projet.dao.ItypeClient;
import com.projet.dao.ItypeCompte;
import com.projet.dao.OperationDB;
import com.projet.dao.TypeClientDB;
import com.projet.dao.TypeCompteDB;
import com.projet.dao.UserDB;
import com.projet.entities.Operation;



public class PROJET_BANQUE_SERVEUR {

	public static void main(String[] args) {
		try {
			Registry registre = LocateRegistry.createRegistry(1222);
			IUser iu = new UserDB();
			IEmployeur iEmp = new EmployeurDB();
			IClient icli = new ClientDB();
			ItypeCompte itc = new TypeCompteDB();
			ICompte icpt = new  CompteDB();
			Ioperation iop = new OperationDB();

			registre.bind("user_db", iu);
			registre.bind("employeur_db", iEmp);
			registre.bind("Client_db", icli);
			registre.bind("typeCompte_db", itc);
			registre.bind("compte_db", icpt);
			registre.bind("operation_db", iop);
			System.out.println("tous les projets distant son enregistrer");


		} catch (Exception e) {

			e.printStackTrace();
		}

	}


}
