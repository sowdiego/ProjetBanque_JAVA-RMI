package com.projet.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projet.entities.Client;
import com.projet.entities.Employeur;
import com.projet.entities.TypeClient;

public class ClientDB extends UnicastRemoteObject implements IClient {



	public ClientDB() throws RemoteException{
		db = new DB();
	}
	private DB db;
	private int ok;
	private ResultSet rs;

	@Override
	public int add(Client cli)  {
		String sql  = "INSERT INTO client VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			db.initPrepare(sql);
			db.getPstm().setString(1, cli.getNum_piece());
			db.getPstm().setString(2, cli.getNom());
			db.getPstm().setString(3, cli.getPrenom());
			db.getPstm().setString(4, cli.getAdresse());
			db.getPstm().setString(5, cli.getTel());
			db.getPstm().setString(6, cli.getEmail());
			db.getPstm().setInt(7, cli.getSalaire());
			db.getPstm().setString(8, cli.getProfession());
			db.getPstm().setString(9, cli.getRaison_sociale());
			db.getPstm().setString(10, cli.getAdressEmp());
			db.getPstm().setString(11,cli.getNomEmp());
			db.getPstm().setString(12, cli.getNumEmp());
			//db.getPstm().setInt(9, cli.getIdEmployeur().getIdEmployeur());

			ok = db.executeMAJ();
			rs = db.getPstm().getGeneratedKeys();
			//ID AUTO_INCREMENT

			while (rs.next()) {
				ok = rs.getInt(1);
			}
			rs.close();
			db.closeConnexion();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;

	}

	@Override
	public int delete(int idClient) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Client cli) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Client> liste() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<TypeClient> listeTC() throws RemoteException {
		List<TypeClient> ltc = new ArrayList<TypeClient>();
		String sql = "SELECT *  FROM typeclient";
		try {
			db.initPrepare(sql);
			rs =db.executeSELECT();
			while (rs.next()) {
				TypeClient tc = new TypeClient();
				tc.setIdTypeClient(rs.getInt(1));
				tc.setNom(rs.getString(2));
				ltc.add(tc);
			}
			rs.close();
			db.closeConnexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ltc;

	}

	@Override
	public List<Employeur> listeEmp() throws RemoteException {
		List<Employeur> lEmp = new ArrayList<Employeur>();
		String sql = "SELECT *  FROM employeur";
		try {
			db.initPrepare(sql);
			rs =db.executeSELECT();
			while (rs.next()) {
				Employeur emp = new Employeur();
				emp.setIdEmployeur(rs.getInt(1));
				emp.setNom(rs.getString(4));
				emp.setNum_id(rs.getString(5));
				emp.setAdress(rs.getString(3));
				emp.setRaison_social(rs.getString(2));
				lEmp.add(emp);
			}
			rs.close();
			db.closeConnexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lEmp;

	}

	@Override
	public String numCompte() throws RemoteException {
	   int num = 0;
	  try {
		String sql = "SELECT * from compte";
		  db.initPrepare(sql);
		  rs= db.executeSELECT();
		  while(rs.next()){
		  num=rs.getInt(1);
		  }
		  rs.close();
		  db.closeConnexion();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "C00"+(num+1);
	}

	@Override
	public Client getClientByCNI(String cni) {
		Client c  = null;
		try {
			String sql="select * from client where CNI=?";

			db.initPrepare(sql);
			db.getPstm().setString(1,cni);
			rs=db.executeSELECT();
			while(rs.next()){
				c = new Client();

				c.setNum_piece(rs.getString(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setAdresse(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setTel(rs.getString(6));
				c.setSalaire(rs.getInt(7));
				c.setProfession(rs.getString(8));
				c.setRaison_sociale(rs.getString(9));
				c.setAdressEmp(rs.getString(10));
				c.setNomEmp(rs.getString(11));
				c.setNumEmp(rs.getString(12));
			}
			rs.close();
			db.closeConnexion();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return c;
	}

}
