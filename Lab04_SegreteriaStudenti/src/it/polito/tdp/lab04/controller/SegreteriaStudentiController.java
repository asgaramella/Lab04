package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;


import it.polito.tdp.lab04.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SegreteriaStudentiController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> comboCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private ImageView btnCercaNome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;


 
    
    @FXML
    void doCercaCorsi(ActionEvent event) {
    	try{
    	int mat=Integer.parseInt(txtMatricola.getText());
    	Studente stemp=model.studenteCercato(mat);
    	if(stemp!=null){
    		LinkedList<Corso> ctemp=new LinkedList<Corso>(model.corsiFrequentati(stemp));
    		if(ctemp.size()!=0){
    		for(Corso c: ctemp){
    			txtResult.appendText(c.getCodice()+"    "+Integer.toString(c.getCrediti())+"    "+c.getNome()+"   "+Integer.toString(c.getPd())+"\n");
    		}
    		}
    		else
    			txtResult.appendText("Studente non iscritto ad alcun corso!\n");
    	}else
    		txtResult.appendText("Studente non presente!");
    	}
    	catch(NumberFormatException e){
    		txtResult.appendText("Caratteri non validi nella matricola !\n");
    	}

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	Corso ctemp=comboCorso.getValue();
    	if(ctemp!=null){
    	LinkedList<Studente> stemp= new LinkedList<Studente>(model.iscritti(ctemp));
    	if(stemp.size()!=0){
    	for(Studente s:stemp){
    		txtResult.appendText(Integer.toString(s.getMatricola())+"    "+
    							s.getNome()+"    "+s.getCognome()+"    "+s.getCds()+"\n");
    	} }else
    		txtResult.appendText("Corso senza iscritti! \n");
    	}
    	else
    		txtResult.appendText("Corso non selezionato!\n");
    }

    @FXML
    void doCercaNome(MouseEvent event) {
    	try{
    	int mat=Integer.parseInt(txtMatricola.getText());
    	Studente s=model.studenteCercato(mat);
    	if(s!=null){
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	if(comboCorso.getValue()!=null){
    		if(model.isIscritto(comboCorso.getValue(), Integer.parseInt(txtMatricola.getText())))
    				txtResult.appendText("Studente già iscritto a questo corso!\n");
    		else
    			txtResult.appendText("Studente non ancora iscritto al corso!\n");
    				
    	 }
    	}
    	else
    		txtResult.appendText("Studente non esistente! \n");
    	}catch(NumberFormatException e){
    		txtResult.appendText("Caratteri non validi nella matricola !\n");
    	}


    }
    
   
    

    @FXML
    void doIscrivi(ActionEvent event) {
    	try{
    	int mat=Integer.parseInt(txtMatricola.getText());
    	Studente stemp=model.studenteCercato(mat);
    	if(stemp!=null && comboCorso.getValue()!=null){
    		if(!model.isIscritto(comboCorso.getValue(),stemp.getMatricola()))
    				{
    				if(model.iscriviStudente(comboCorso.getValue(), stemp))
    					txtResult.appendText("Studente iscritto al corso!\n");
    				}
    		else
    			txtResult.appendText("Impossile iscrizione, già iscritto!\n");
    	}
    	}catch(NumberFormatException e){
    		txtResult.appendText("Caratteri non validi nella matricola !\n");
    	}


    }

    @FXML
    void doReset(ActionEvent event) {
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    	txtMatricola.clear();

    }

    @FXML
    void initialize() {
        assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
       
    }

	public void setModel(Model model) {
			this.model=model;
			
	        comboCorso.getItems().addAll(model.getNomiCorsi());
	        
		
		
	}
}

