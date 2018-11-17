package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.SzemelyDao;
import impl.SzemelyDaoImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Szemely;

public class ViewController implements Initializable{ //beírom hogy implements Initializable, aztán add ... methods

    @FXML
    private TableView<Szemely> tabla;
    
    @FXML
    private TableColumn<Szemely, String> tablaID; //<?, ?> cserélem erre <Szemely, String>

    @FXML
    private TableColumn<Szemely, String> tablaVezNev;

    @FXML
    private TableColumn<Szemely, String> tablaKerNev;

    @FXML
    private TableColumn<Szemely, String> tablaSzulDatum;

    @FXML
    private TextField idMezo;

    @FXML
    private TextField VezNevMezo;

    @FXML
    private TextField KerNevMezo;

    @FXML
    private TextField SzulDatumMezo;
    
    //új
    private SzemelyDao db = new SzemelyDaoImpl();
    
    private ObservableList<Szemely> tablaAdatok = db.get(); 

    @FXML
    void menuItemKilepes(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void menuItemNevjegy(ActionEvent event) {

    }
    
    @FXML
    void menuItemSzerkeszt(ActionEvent event) {
    	Szemely szemelySzerkeszt = tabla.getSelectionModel().getSelectedItem();
    	tablaAdatok.remove(szemelySzerkeszt);
    	idMezo.setText(szemelySzerkeszt.getId());
    	VezNevMezo.setText(szemelySzerkeszt.getVezeteknev());
    	KerNevMezo.setText(szemelySzerkeszt.getKeresztnev());
    	SzulDatumMezo.setText(szemelySzerkeszt.getSzuletesidatum());
    }
    
    //töröl
    @FXML
    void menuItemTorol(ActionEvent event) {
    	Szemely szemelyTorol = tabla.getSelectionModel().getSelectedItem();
    	db.remove(szemelyTorol);
    	tablaFrissit();
    }
    
    @FXML
    void hozzadGomb(ActionEvent event) {
    	Szemely szemelyAdd = new Szemely();
    	szemelyAdd.setId(idMezo.getText());
    	szemelyAdd.setVezeteknev(VezNevMezo.getText());
    	szemelyAdd.setKeresztnev(KerNevMezo.getText());
    	szemelyAdd.setSzuletesidatum(SzulDatumMezo.getText());
    	db.add(szemelyAdd);
    	tablaFrissit();
    }
    
    @FXML
    void hozzadSzerkeszt(ActionEvent event) {
    	Szemely szemelySzerkeszt = new Szemely();
    	szemelySzerkeszt.setId(idMezo.getText());
    	szemelySzerkeszt.setVezeteknev(VezNevMezo.getText());
    	szemelySzerkeszt.setKeresztnev(KerNevMezo.getText());
    	szemelySzerkeszt.setSzuletesidatum(SzulDatumMezo.getText());
    	db.update(szemelySzerkeszt);
    	tablaFrissit();
    	
    }
    
    
    //setTableData
    private void tablaAdatokBeallitasa() {
    	tablaID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
    	tablaVezNev.setCellValueFactory(cellData -> cellData.getValue().vezeteknevProperty());
    	tablaKerNev.setCellValueFactory(cellData -> cellData.getValue().keresztnevProperty());
    	tablaSzulDatum.setCellValueFactory(cellData -> cellData.getValue().szuletesidatumProperty());
    	
    	tabla.setItems(tablaAdatok);
    }
    
    private void tablaFrissit() {
    	tablaAdatok = db.get();
    	tabla.setItems(tablaAdatok);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		tablaAdatokBeallitasa();
		
	}

}
