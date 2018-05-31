package com.projet.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.projet.entities.TypeCompte;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class TypeCompteDB extends UnicastRemoteObject implements ItypeCompte {

	private DB db;
	private int ok;
	private ResultSet rs;

	public TypeCompteDB() throws RemoteException {
		db = new DB();
	}
	@Override
	public List<TypeCompte> listeTC() throws RemoteException {
		List<TypeCompte> ltc = new  ArrayList<TypeCompte>();

		String sql = "SELECT *  FROM typecompte";
		try {
			db.initPrepare(sql);
			rs =db.executeSELECT();
			while (rs.next()) {
				TypeCompte tc = new TypeCompte();
				tc.setIdCompte(rs.getInt(1));//s.setIdServ(rs.getInt("idServ"));
				tc.setNomType(rs.getString(2));
				ltc.add(tc);
			}
			rs.close();
			db.closeConnexion();
		} catch (Exception e) {

		}
		return  ltc;
	}



}
