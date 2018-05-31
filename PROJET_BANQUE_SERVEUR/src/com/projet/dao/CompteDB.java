package com.projet.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.projet.entities.Agence;
import com.projet.entities.Charge_Compte;
import com.projet.entities.Client;
import com.projet.entities.Compte;
import com.projet.entities.TypeCompte;
import com.sun.javafx.image.impl.ByteIndexed.Getter;

public class CompteDB extends UnicastRemoteObject implements ICompte {
	public CompteDB() throws RemoteException{
		db = new DB();
	}
	private DB db;
	private int ok;
	private ResultSet rs;
	@Override
	public int add(Compte c) {
		String sql  = "INSERT INTO compte VALUES(NULL,?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)";
		try {
			db.initPrepare(sql);
			db.getPstm().setString(1, c.getNumero());
			db.getPstm().setString(2,c.getDateOuverture());
			db.getPstm().setInt(3, c.getSolde());
			db.getPstm().setInt(4, c.getFraisOuverture());
			db.getPstm().setString(5,c.getRemuneration());
			db.getPstm().setInt(6, c.getAgio());
			db.getPstm().setInt(7, c.getDelaiBlocage());
			db.getPstm().setString(8, c.getEtatCompte());
			db.getPstm().setString(9, c.getDateEcheance());
			db.getPstm().setString(10, c.getDateGele());
			db.getPstm().setInt(11, c.getTypeCompte().getIdCompte());
			db.getPstm().setString(12,c.getClient().getNum_piece());
			db.getPstm().setInt(13, c.getChargeCompte().getIdChargeCompte());
			db.getPstm().setInt(14, c.getAgence().getIdAgence());
			db.getPstm().setString(15, c.getCleRIB());
			//db.getPstm().setInt(9, cli.getIdEmployeur().getIdEmployeur());
			ok = db.executeMAJ();
			//rs = db.getPstm().getGeneratedKeys();
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
	public List<Charge_Compte> listeChC() throws RemoteException {
		List<Charge_Compte> lchc = new  ArrayList<Charge_Compte>();

		String sql = "SELECT *  FROM charger_compte";
		try {
			db.initPrepare(sql);
			rs =db.executeSELECT();
			while (rs.next()) {
				Charge_Compte chc = new Charge_Compte();
				chc.setIdChargeCompte(rs.getInt(1));//s.setIdServ(rs.getInt("idServ"));
				chc.setNom(rs.getString(2));
				chc.setPrenom((rs.getString(3)));
				chc.setAdresse((rs.getString(4)));
				chc.setTel((rs.getString(5)));
				lchc.add(chc);
			}
			rs.close();
			db.closeConnexion();
		} catch (Exception e) {

		}
		return  lchc;

	}
	@Override
	public List<Agence> listeAg() throws RemoteException {
		List<Agence> lAg = new  ArrayList<Agence>();

		String sql = "SELECT *  FROM agence";
		try {
			db.initPrepare(sql);
			rs =db.executeSELECT();
			while (rs.next()) {
				Agence ag = new Agence();
				ag.setIdAgence(rs.getInt(1));
				ag.setNom(rs.getString(2));
				ag.setLocalite((rs.getString(3)));
				lAg.add(ag);
			}
			rs.close();
			db.closeConnexion();
		} catch (Exception e) {

		}
		return  lAg;

	}
	@Override
	public String cleRIB() throws RemoteException {
		int num=0;
		  try {
			String sql = "SELECT * from agence";
			  db.initPrepare(sql);
			  db.executeSELECT();
			  while(rs.next()){}
			  num=rs.getInt(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return "Key"+" "+num+1;
	}
	@Override
	public Compte getCompteByNum(String numCompte) throws RemoteException {
		Compte c  = null;
		try {
			String sql="select * from compte where numero=?";

			db.initPrepare(sql);
			db.getPstm().setString(1,numCompte);
			rs=db.executeSELECT();
			while(rs.next()){
				c = new Compte();
                c.setIdCompte(rs.getInt(1));
				c.setNumero(rs.getString(2));
				c.setSolde(rs.getInt(4));
				c.setClient(getClientByCNI(rs.getString(13)));
				c.setCleRIB(rs.getString(15));//setNum_piece(rs.getString(13));

			}
			rs.close();
			db.closeConnexion();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return c;

	}
	@Override
	public int updateSolde(int soldeRetrait, String numCompte) throws RemoteException {
	int n=0;
	try {
	String sql="update compte set solde=solde-? where numero = ?";
	db.initPrepare(sql);

		db.getPstm().setInt(1,soldeRetrait);
		db.getPstm().setString(2,numCompte);

		n=db.executeMAJ();
		db.closeConnexion();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return n;
	}
	@Override
	public int updateSoldeDepot(int soldeRetrait, String numCompte) throws RemoteException {
		int n=0;
		try {
		String sql="update compte set solde=solde+? where numero = ?";
		db.initPrepare(sql);

			db.getPstm().setInt(1,soldeRetrait);
			db.getPstm().setString(2,numCompte);
			n=db.executeMAJ();
			db.closeConnexion();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return n;

	}
	@Override
	public Client getClientByCNI(String cni) throws RemoteException {
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
