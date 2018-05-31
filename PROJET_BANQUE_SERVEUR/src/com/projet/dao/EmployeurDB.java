package com.projet.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

import com.projet.entities.Employeur;


public class EmployeurDB extends UnicastRemoteObject implements IEmployeur{

	private DB db;
	private int ok;
	private ResultSet rs;

	public EmployeurDB() throws RemoteException{
		db = new DB();
	}

	@Override
	public int add(Employeur emp) throws RemoteException {
		String sql  = "INSERT INTO employeur VALUES(NULL, ?, ?, ?, ?)";
		try {
			db.initPrepare(sql);
			db.getPstm().setString(1, emp.getRaison_social());
			db.getPstm().setString(2,emp.getAdress());
			db.getPstm().setString(3, emp.getNom());
			db.getPstm().setString(4, emp.getNum_id());
			ok = db.executeMAJ();
			rs = db.getPstm().getGeneratedKeys();
			//ID AUTO_INCREMENT
			rs = db.getPstm().getGeneratedKeys();
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

}
