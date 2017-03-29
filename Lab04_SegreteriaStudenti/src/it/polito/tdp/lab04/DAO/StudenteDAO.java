package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente completaDatiStudenti(int mat){
		Studente result=null;
		String sql= "SELECT MATRICOLA,NOME,COGNOME "+
				"FROM STUDENTE "+
				"WHERE MATRICOLA=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1,mat);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Studente stud=new Studente(rs.getInt("matricola"),rs.getString("cognome"), rs.getString("nome"));
				result=stud;
			}
			conn.close();

	

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		
		}
		return result;
		
	}


}
