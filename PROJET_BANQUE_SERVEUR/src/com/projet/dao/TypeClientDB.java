package com.projet.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projet.entities.TypeClient;


public class TypeClientDB extends UnicastRemoteObject implements ItypeClient {
	private DB db;
	private int ok;
	private ResultSet rs;

	public  TypeClientDB() throws RemoteException {
		db = new DB();
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
}
