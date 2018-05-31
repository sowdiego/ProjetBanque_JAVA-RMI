package com.projet.dao;

import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.Objects;

public class DB {
	private Connection cnx;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	private int ok;
	//ouverture de la connexion a la base de données
	public void getConnexion(){
		String url = "jdbc:mysql://localhost:3306/banque_du_peuple";
		String user = "root";
		String password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, user, password);
			//System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("non ok");
		}
	}
	//preparation des requetes sql
	public PreparedStatement initPrepare(String sql){
		try {
			getConnexion();
			if(sql.toLowerCase().startsWith("insert")){
				pstm = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			}else{
				pstm = cnx.prepareStatement(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pstm;
	}
	//execution des requetes de type MAJ (UPDATE - DELETE - INSERT)
	public int executeMAJ(){
		try {
			ok = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	//execution des requetes de type SELECT
	public ResultSet executeSELECT(){
		try {
			rs = pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public PreparedStatement getPstm() {
		return pstm;
	}
	public void closeConnexion() {
		try {
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*public void AddParametre(String nom , Objects value)
    {
        Parameter.Add(new SqlParameter(nom, value));
    }*/

}
