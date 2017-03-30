package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				String codice= rs.getString("codins");
				int crediti=rs.getInt("crediti");
				String nome=rs.getString("nome");
				int pd=rs.getInt("pd");
				corsi.add(new Corso(codice,crediti,nome,pd));
			}
			conn.close();

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		String sql ="SELECT s.matricola,s.nome,s.cognome ,s.CDS "+
				"FROM STUDENTE as s ,corso as c, iscrizione as i "+
				"WHERE  i.codins=c.codins and i.matricola=s.matricola  and  c.nome=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, corso.getNome());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola=rs.getInt("s.matricola");
				String nome=rs.getString("s.nome");
				String cognome=rs.getString("s.cognome");
				String cds=rs.getString("s.CDS");
				Studente temp=new Studente(matricola,cognome,nome);
				corso.setStudenteIn(temp);
				if(cds!=null)
					temp.setCds(cds);
			}
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}

	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		
			String sql = "INSERT INTO `iscritticorsi`.`iscrizione` (`matricola`, `codins`) VALUES (?,?);";
			
			
			try {
				Connection conn = ConnectDB.getConnection();
				
				PreparedStatement st=conn.prepareStatement(sql);
				
				st.setString(1,Integer.toString(studente.getMatricola()));
				st.setString(2, corso.getCodice());
				
				int result=st.executeUpdate();
				conn.close();
				
				if(result==1){
					return true;}
				else {
					return false;}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			}
			return false;
			
			
		}
	}

