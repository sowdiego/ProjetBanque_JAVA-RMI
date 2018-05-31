package com.projet.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projet.entities.User;





public class UserDB extends UnicastRemoteObject implements IUser {

	private DB db;
	private ResultSet rs;
	private boolean bol;

	public UserDB() throws RemoteException{
		db = new DB();
	}

	@Override
	public boolean getConnexion(User u) throws RemoteException {
		String sql = "SELECT * FROM user WHERE loginU = ? AND passwordU = ?";
		try {

			db.initPrepare(sql);
			db.getPstm().setString(1, u.getLoginU());
			db.getPstm().setString(2, u.getPasswordU());
			ResultSet rs = db.executeSELECT();
			while (rs.next()) {
				bol = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bol;
	}



	/*@Override
	public List<String> listeProfil() throws RemoteException {

		List<String> l_profil= new ArrayList<String>();
		String sql = "select * from user";
		try {
			db.initPrepare(sql);
			rs = db.executeSELECT();
			while(rs.next()){

				User u = new User();
				u.setIdU(rs.getInt(1));
				u.setLoginU(rs.getString(2));
				u.setPasswordU(rs.getString(3));
				u.setProfil(rs.getString(4));
				l_profil.add(u.getProfil());
			}
			rs.close();
			db.closeConnexion();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return l_profil;
	}*/

}
