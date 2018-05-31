package com.projet.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.projet.entities.Operation;

public class OperationDB extends UnicastRemoteObject implements Ioperation {

public OperationDB() throws RemoteException {
		db = new DB();
	}
	private DB db;
	private int ok;
	private ResultSet rs;
	@Override
	public int add(Operation op) throws RemoteException {
		String sql  = "INSERT INTO operation VALUES(NULL,?, ?, ?, ?, ?, ?)";
		try {
			db.initPrepare(sql);
			db.getPstm().setString(1, op.getDate());
			db.getPstm().setInt(2,op.getMontant());
			db.getPstm().setInt(3, op.getTaxe());
			db.getPstm().setInt(4, op.getCompte().getIdCompte());
			db.getPstm().setString(5,op.getTypeOp());
			db.getPstm().setInt(6, op.getAgence().getIdAgence());

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
	public Operation getOpereationByDate(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
